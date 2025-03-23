package com.example.mathgameapp.ui

data class GameUiState(
    val currentQuestion: String = "",
    val correctAnswers: Int = 0,
    val wrongAnswers: Int = 0,
    val currentAnswer: String = "",
    val totalQuestions: Int = 5, // Default value
    val questionIndex: Int = 0,
    val isGameFinished: Boolean = false
)
