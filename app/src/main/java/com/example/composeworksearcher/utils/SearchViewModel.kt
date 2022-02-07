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

) : BaseViewModel<SearchUiState, SearchUiState>() {

    init {
        launch {
            delay(2000)
            uiBehaviour.value = SearchUiState.Content
            delay(2000)
            uiBehaviour.value = SearchUiState.Loading
        }
    }

    /*val filters: List<Filter>
        get() = _filters
    private val _filters: MutableList<Filter> = mutableListOf()

    val positions: List<Position>
        get() = _positions
    private val _positions: MutableList<Position> = mutableListOf()*/

    override val uiBehaviour: MutableStateFlow<SearchUiState> =
        MutableStateFlow(SearchUiState.Loading)

    override fun collectAction(action: SearchUiState) {
        when (action) {

        }
    }

}

sealed class SearchUiState {
    object Loading : SearchUiState()
    object Content : SearchUiState()
}

sealed class SearchAction {

}