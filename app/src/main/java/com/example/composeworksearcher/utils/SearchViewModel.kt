package com.example.composeworksearcher.utils

import androidx.lifecycle.ViewModel
import com.example.composeworksearcher.data.Filter
import com.example.composeworksearcher.data.Position
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(

) : ViewModel() {
    val filters: List<Filter>
        get() = _filters
    private val _filters: MutableList<Filter> = mutableListOf()

    val positions: List<Position>
        get() = _positions
    private val _positions: MutableList<Position> = mutableListOf()
}