package com.example.composeworksearcher.ui

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composeworksearcher.R
import com.example.composeworksearcher.ui.screens.Favorite
import com.example.composeworksearcher.ui.screens.Messages
import com.example.composeworksearcher.ui.screens.Profile
import com.example.composeworksearcher.ui.screens.Search
import com.example.composeworksearcher.ui.theme.MainTheme
import com.example.composeworksearcher.ui.theme.bottomNavigationSelectedColor
import com.example.composeworksearcher.ui.theme.bottomNavigationUnselectedColor


enum class MainScreenNavigation(
    val screenRoute: String,
    @StringRes val resourceId: Int,
    @DrawableRes val iconId: Int
) {
    Search("home/search", R.string.search, R.drawable.ic_round_search_24),
    Favorite("home/favorite", R.string.favorite, R.drawable.ic_round_star_24),
    Messages("home/messages", R.string.messages, R.drawable.ic_round_question_answer_24),
    Profile("home/profile", R.string.profile, R.drawable.ic_round_account_circle_24)
}

fun NavGraphBuilder.addHomeGraph(
    modifier: Modifier = Modifier
) {
    composable(MainScreenNavigation.Search.screenRoute) { from ->
        Search()
    }
    composable(MainScreenNavigation.Favorite.screenRoute) { from ->
        Favorite()
    }
    composable(MainScreenNavigation.Messages.screenRoute) { from ->
        Messages()
    }
    composable(MainScreenNavigation.Profile.screenRoute) { from ->
        Profile()
    }
}

@Composable
fun MainScreenBottomBar(
    items: Array<MainScreenNavigation>,
    currentRoute: String,
    navigateTo: (String) -> Unit
) {
    val section = items.first { it.screenRoute == currentRoute }

    BottomNavigation {
        items.forEach {
            val selected = section == it
            BottomNavigationItem(
                icon = { Icon(painterResource(id = it.iconId), "") },
                label = { Text(stringResource(id = it.resourceId)) },
                selected = selected,
                alwaysShowLabel = true,
                onClick = {
                    if (currentRoute != it.screenRoute) {
                        navigateTo(it.screenRoute)
                    }
                },
                selectedContentColor = MaterialTheme.colors.bottomNavigationSelectedColor,
                unselectedContentColor = MaterialTheme.colors.bottomNavigationUnselectedColor,
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun BottomNavigationPreview() {
    MainTheme {
        MainScreenBottomBar(
            items = MainScreenNavigation.values(),
            currentRoute = "home/search",
            navigateTo = {}
        )
    }
}

