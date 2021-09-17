package com.example.composeworksearcher.ui

import android.content.res.Resources
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

object MainScreenRoute {
    const val HOME_ROUTE = "home"
}

@Composable
fun rememberMainScreenState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    resources: Resources = resources(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) = remember(scaffoldState, navController, resources, coroutineScope) {
    MainScreenStateHolder(scaffoldState, navController, resources, coroutineScope)
}

@Stable
class MainScreenStateHolder(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
    val resources: Resources,
    coroutineScope: CoroutineScope
) {
    val startDestination: String
        get() = MainScreenNavigation.Search.screenRoute

    val routeList: Array<MainScreenNavigation>
        get() = MainScreenNavigation.values()
    private val bottomBarRoutes = routeList.map { it.screenRoute }

    // Reading this attribute will cause recompositions when the bottom bar needs shown, or not.
    // Not all routes need to show the bottom bar.
    val shouldShowBottomBar: Boolean
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination?.route in bottomBarRoutes

    val currentRoute: String?
        get() = navController.currentDestination?.route

    fun navigateUp() {
        navController.navigateUp()
    }

    fun navigateTo(route: String) {
        if (route != currentRoute) {
            navController.navigate(route) {
                launchSingleTop = true
                restoreState = true
                popUpTo(navController.graph.startDestination?.id!!) {
                    saveState = true
                }
            }
        }
    }
}

private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

@Composable
@ReadOnlyComposable
private fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
}