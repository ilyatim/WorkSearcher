package com.example.composeworksearcher.utils

import androidx.lifecycle.ViewModel
import com.example.composeworksearcher.data.Filter
import com.example.composeworksearcher.data.Position
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(

) : ViewModel(), CoroutineScope by MainScope() {

    init {
        launch {
            delay(2000)
            _state.value = SearchUiState.Content
            delay(2000)
            _state.value = SearchUiState.Loading
        }
    }

    val filters: List<Filter>
        get() = _filters
    private val _filters: MutableList<Filter> = mutableListOf()

    val positions: List<Position>
        get() = _positions
    private val _positions: MutableList<Position> = mutableListOf()

    val state: StateFlow<SearchUiState>
        get() = _state.asStateFlow()

    private val _state: MutableStateFlow<SearchUiState> = MutableStateFlow(SearchUiState.Loading)

}

sealed class SearchUiState {
    object Loading : SearchUiState()
    object Content : SearchUiState()
}