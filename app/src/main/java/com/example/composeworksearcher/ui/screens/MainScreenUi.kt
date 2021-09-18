package com.example.composeworksearcher.ui.activity

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.composeworksearcher.ui.*


@Composable
fun MainScreen() {
    val screenState = rememberMainScreenState()
    Scaffold(
        bottomBar = {
            if (screenState.shouldShowBottomBar) {
                MainScreenBottomBar(
                    items = screenState.routeList,
                    currentRoute = screenState.currentRoute!!,
                    navigateTo = screenState::navigateTo
                )
            }
        },
        scaffoldState = screenState.scaffoldState
    ) {
        NavHost(
            navController = screenState.navController,
            startDestination = MainScreenRoute.HOME_ROUTE,
        ) {
            createNavGraph()
        }
    }
}

private fun NavGraphBuilder.createNavGraph() {
    navigation(
        route = "home",
        startDestination = MainScreenNavigation.Search.screenRoute
    ) {
        addHomeGraph(/*onSnackSelected*/)
    }
}