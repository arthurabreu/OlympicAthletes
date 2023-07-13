package com.arthurabreu.olympicathletes.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arthurabreu.olympicathletes.data.AthleteResults
import com.arthurabreu.olympicathletes.data.Participation
import com.arthurabreu.olympicathletes.network.OlympicRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val repository = OlympicRepository()

    private val _participation = MutableStateFlow(listOf<Participation>())
    val participation = _participation.asStateFlow()

    init {
        fetchGames()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun fetchGames() {
        viewModelScope.launch(Dispatchers.IO) {
            val combinedAthletesGames = flow {
                val participations = mutableListOf<Participation>()

                val gamesAvailable = repository.getGames()

                gamesAvailable.asFlow()
                    .flatMapConcat { game ->
                        flow {
                            val gamesAthletes = repository.getGamesAthletes(game.gameId)
                            gamesAthletes.forEach { athlete ->
                                val results = repository.getAthleteResults(athlete.athleteID)
                                athlete.score = calculateScore(results)
                                athlete.image =
                                    "https://ocs-test-backend.onrender.com/athletes/" +
                                            "${athlete.athleteID}/photo"
                            }
                            val sortedAthletes = gamesAthletes.sortedByDescending { it.score }
                            emit(Participation(
                                game.year,
                                game.city + " " + game.year,
                                sortedAthletes
                            ))
                        }
                    }
                    .collect { participation ->
                        participations.add(participation)
                    }

                emit(participations)
            }


            val participationResult = combinedAthletesGames.onCompletion { cause ->
                if (cause != null) {
                    // Handle any exception or cancellation
                    Log.e(
                        HomeViewModel::class.java.simpleName,
                        "Flow completed with exception: $cause"
                    )
                }
            }

            participationResult.collect { completedParticipations ->
                val sortedParticipations = completedParticipations.sortedByDescending { it.year }
                _participation.emit(sortedParticipations)
                Log.i(
                    HomeViewModel::class.java.simpleName,
                    "Completed Participations: ${completedParticipations.size}"
                )
            }
        }
    }

    private fun calculateScore(athleteResults: List<AthleteResults>): Int {
        return athleteResults.sumOf { it.gold * 5 + it.silver * 3 + it.bronze }
    }
}