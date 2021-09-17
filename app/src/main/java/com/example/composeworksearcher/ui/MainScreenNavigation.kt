package com.example.composeworksearcher.ui

import android.content.res.Configuration
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeworksearcher.R
import com.example.composeworksearcher.ui.theme.MainTheme

enum class MainScreenNavigation(
    val screenRoute: String,
    @StringRes val resourceId: Int,
    @DrawableRes val iconId: Int
) {
    Search("home/search", R.string.search, R.drawable.ic_round_search_24),
    Favorite("home/favorite", R.string.favorite, R.drawable.ic_round_star_24),
    Messages("home/messages", R.string.messages, R.drawable.ic_round_question_answer_24),
    Profile("home/profile", R.string.profile,R.drawable.ic_round_account_circle_24)
}

fun NavGraphBuilder.addHomeGraph(
    modifier: Modifier = Modifier
) {
    composable(MainScreenNavigation.Search.screenRoute) { from ->

    }
    composable(MainScreenNavigation.Favorite.screenRoute) { from ->

    }
    composable(MainScreenNavigation.Messages.screenRoute) { from ->

    }
    composable(MainScreenNavigation.Profile.screenRoute) { from ->

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
                }
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun BottomNavigationPreview() {
    MainTheme {
        MainScreenBottomBar(
            items = MainScreenNavigation.values(),
            currentRoute = "home/search",
            navigateTo = {}
        )
    }
}
