package com.example.mathgameapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun ResultScreen(navController: NavController, gameViewModel: GameViewModel = viewModel()) {
    val uiState = gameViewModel.uiState

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center) {
        Text("Game Over!", style = MaterialTheme.typography.headlineLarge)
        Text("Correct: ${uiState.correctAnswers}")
        Text("Wrong: ${uiState.wrongAnswers}")

        Button(onClick = {
            gameViewModel.resetGame()
            navController.popBackStack("startScreen", inclusive = false) // Navigate to the start screen
        }) {
            Text("Play Again")
        }
    }
}
