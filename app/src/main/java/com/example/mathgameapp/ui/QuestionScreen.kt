package com.example.mathgameapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun QuestionScreen(navController: NavController, gameViewModel: GameViewModel = viewModel()) {
    val uiState = gameViewModel.uiState
    var userAnswer by remember { mutableStateOf("") }
    var isInputValid by remember { mutableStateOf(true) }

    // Automatically navigate if the game is finished
    LaunchedEffect(uiState.isGameFinished) {
        if (uiState.isGameFinished) {
            navController.navigate("resultScreen")
        }
    }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("Correct: ${uiState.correctAnswers} | Wrong: ${uiState.wrongAnswers}")
        Text(uiState.currentQuestion, style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(value = userAnswer, onValueChange = { userAnswer = it })

        Button(onClick = {
           if(userAnswer.isNotBlank()) {
               gameViewModel.submitAnswer(userAnswer)
           } // Submit the answer and move to the next question
            userAnswer = ""
        }) {
            Text("Next")
        }

        Button(onClick = { navController.navigate("resultScreen") }) {
            Text("Cancel")
        }
    }
}
