package com.example.composeworksearcher.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composeworksearcher.data.MainScreen
import com.example.composeworksearcher.ui.theme.MainTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                MainScreen()
            }
        }
    }

    @Composable
    fun MainScreen() {
        val navController = rememberNavController()

        val bottomNavigationList = listOf(
            "Some",
            "body",
            "once",
            "told me"
        )

        Scaffold(
            bottomBar = { MainScreenBottomBar(navController, bottomNavigationList) }
        ) {
            MainScreenAppNavigationConfiguration(navController)
        }
    }

    @Composable
    fun MainScreenAppNavigationConfiguration(navController: NavController) {

    }

    @Composable
    fun MainScreenBottomBar(navController: NavController, items: List<MainScreen>) {
        BottomNavigation {
            val currentScreen = CurrentScreen(navController)

            items.forEach {
                BottomNavigationItem(
                    icon = { Icon(it.iconId) },
                    label = { Text(stringResource(id = it.resourceId))},
                    selected = currentScreen == it.screenName,
                    alwaysShowLabel = true,
                    onClick = {
                        if (currentScreen != it.screenName) {
                            navController.navigate(it.screenName)
                        }
                    }
                )
            }
        }
    }

    @Composable
    fun CurrentScreen(navController: NavController): String? {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
    }
}