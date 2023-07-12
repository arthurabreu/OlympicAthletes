package com.arthurabreu.olympicathletes.ui.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arthurabreu.olympicathletes.data.Athlete
import com.arthurabreu.olympicathletes.data.AthleteResults
import com.arthurabreu.olympicathletes.network.OlympicRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val repository = OlympicRepository()

    private val _athlete = MutableStateFlow<Athlete?>(null)
    val athlete = _athlete.asStateFlow()

    private val _athleteResults = MutableStateFlow(listOf<AthleteResults>())
    val athleteResults = _athleteResults.asStateFlow()

    private val argument = checkNotNull(savedStateHandle.get<String>("athlete_details_id"))

    init {
        fetchAthleteDetails()
        fetchAthleteResults()
    }

    private fun fetchAthleteDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            val athlete = repository.getAthleteDetails(argument.toInt())
            _athlete.emit(athlete)
        }
    }

    private fun fetchAthleteResults() {
        viewModelScope.launch(Dispatchers.IO) {
            val results = repository.getAthleteResults(argument.toInt())
            _athleteResults.emit(results)
        }
    }
}