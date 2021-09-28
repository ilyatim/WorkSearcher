package com.example.composeworksearcher.ui.screens

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeworksearcher.R
import com.example.composeworksearcher.ui.rememberMainScreenState
import com.example.composeworksearcher.ui.theme.MainTheme
import com.example.composeworksearcher.ui.view.BaseSurface
import com.example.composeworksearcher.ui.view.MaterialLoading
import com.example.composeworksearcher.utils.SearchUiState
import com.example.composeworksearcher.utils.SearchViewModel

@Composable
fun Search(
    viewModel: SearchViewModel = viewModel()
) {
    BaseSearchHint()
    
    val state = remember { viewModel.state }.collectAsState()

    when (state.value) {
        SearchUiState.Loading -> {
            MaterialLoading()
            Log.d("sometag", "loading")
        }
        SearchUiState.Content -> {
            Log.d("sometag", "content")
        }
    }
    /*Surface(modifier = Modifier.fillMaxSize()) {

    }*/
}

@Composable
fun BaseSearchHint(
    searchText: String = stringResource(id = R.string.search_hint)
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    ) {
        Icon(
            imageVector = Icons.Outlined.Search,
            contentDescription = stringResource(R.string.label_search)
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = searchText,
            //color = JetsnackTheme.colors.textHelp
        )
    }
}

@Preview(name = "day", showBackground = true)
@Preview(name = "night", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun BaseSearchPreview() {
    MainTheme {
        BaseSurface {
            BaseSearchHint()
        }
    }
}