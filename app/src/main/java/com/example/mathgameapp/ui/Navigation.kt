package com.example.mathgameapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(navController: NavHostController, gameViewModel: GameViewModel) {
    NavHost(navController = navController, startDestination = "startScreen") {
        composable("startScreen") { StartScreen(navController, gameViewModel) }
        composable("questionScreen") { QuestionScreen(navController, gameViewModel) }
        composable("resultScreen") { ResultScreen(navController, gameViewModel) }
    }
}
