package com.example.recepies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.recepies.Screen
import com.example.recepies.ui.main_screen.MainScreen
import com.example.recepies.ui.main_screen.MainScreenViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController, viewModel = MainScreenViewModel())
        }
        composable(
            route = Screen.PdpScreen.route +"/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        )
        {
//            entry ->
//            Pdp(name = entry.arguments?.getString("name"))
            "text"

        }
    }
}