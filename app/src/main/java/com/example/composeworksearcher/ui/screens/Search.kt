package com.example.composeworksearcher.ui.screens

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
import com.example.composeworksearcher.ui.theme.surfaceSearchBarBackground
import com.example.composeworksearcher.ui.view.BaseSurface
import com.example.composeworksearcher.ui.view.MaterialLoading
import com.example.composeworksearcher.ui.view.SearchList
import com.example.composeworksearcher.utils.SearchUiState
import com.example.composeworksearcher.utils.SearchViewModel

@Composable
fun Search(
    viewModel: SearchViewModel = viewModel()
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp, top = 8.dp, bottom = 16.dp)
            .fillMaxWidth()
    ) {
        BaseSurface(
            contentAlignment = Alignment.Center,
            color = MaterialTheme.colors.surfaceSearchBarBackground,
            modifier = Modifier
                .padding(end = 5.dp)
                .height(54.dp)
                .fillMaxWidth()
                .weight(5f)
                .clip(RoundedCornerShape(10.dp))
        ) {
            BaseSearchHint()
        }
        BaseSurface(
            contentAlignment = Alignment.Center,
            color = MaterialTheme.colors.surfaceSearchBarBackground,
            modifier = Modifier
                .height(54.dp)
                .width(54.dp)
                .weight(1f)
                .clip(RoundedCornerShape(10.dp))
        ) {
            Icon(
                painterResource(id = R.drawable.ic_baseline_list_24),
                "list",
                tint = MaterialTheme.colors.onSurface
            )
        }
    }

    val state = remember { viewModel.getUiState() }.collectAsState()

    when (val behaviour = state.value) {
        SearchUiState.Loading -> {
            MaterialLoading()
        }
        SearchUiState.Content -> {
            SearchList(/*behaviour.list*/)
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
            .wrapContentSize()
    ) {
        Icon(
            modifier = Modifier.padding(start = 10.dp),
            imageVector = Icons.Outlined.Search,
            contentDescription = stringResource(R.string.label_search),
        )
        Spacer(Modifier.width(8.dp))
        Text(
            modifier = Modifier.padding(end = 10.dp),
            text = searchText,
        )
    }
}

@Preview(name = "day", showBackground = true)
@Preview(name = "night", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun BaseSearchPreview() {
    MainTheme {
        Search()
    }
}
