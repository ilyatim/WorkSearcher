package com.example.composeworksearcher.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeworksearcher.utils.SearchViewModel

@Composable
fun Search(
    viewModel: SearchViewModel = viewModel()
) {
    Text(text = "Search")
    /*Surface(modifier = Modifier.fillMaxSize()) {

    }*/
}