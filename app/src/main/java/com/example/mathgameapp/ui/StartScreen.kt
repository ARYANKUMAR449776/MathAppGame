package com.example.mathgameapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun StartScreen(navController: NavController, gameViewModel: GameViewModel = viewModel()) {
    var questionCount by remember { mutableStateOf("5") }

    Column(modifier = Modifier.fillMaxSize()
        .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("Math Game", style = MaterialTheme.typography.headlineLarge)

        OutlinedTextField(
            value = questionCount,
            onValueChange = { questionCount = it },
            label = { Text("Number of Questions") }
        )

        Button(onClick = {
            gameViewModel.startGame(questionCount.toIntOrNull() ?: 5)
            navController.navigate("questionScreen")
        }) {
            Text("Start Game")
        }
    }
}
