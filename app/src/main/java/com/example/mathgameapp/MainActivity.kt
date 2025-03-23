package com.example.mathgameapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.mathgameapp.ui.AppNavigation
import com.example.mathgameapp.ui.GameViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val gameViewModel: GameViewModel = viewModel() // Correct way to initialize ViewModel in Compose

            AppNavigation(navController, gameViewModel)
        }
    }
}
