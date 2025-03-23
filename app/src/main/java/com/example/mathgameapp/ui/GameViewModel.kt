package com.example.mathgameapp.ui

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import kotlin.random.Random

class GameViewModel : ViewModel() {

    var uiState by mutableStateOf(GameUiState())
        private set

    private var questionsList: List<Pair<Int, Int>> = emptyList()

    fun startGame(totalQuestions: Int) {
        questionsList = List(totalQuestions) {
            Random.nextInt(1, 100) to Random.nextInt(1, 100)
        }
        uiState = uiState.copy(
            totalQuestions = totalQuestions,
            questionIndex = 0,
            correctAnswers = 0,
            wrongAnswers = 0,
            isGameFinished = false
        )
        generateQuestion()
    }

    fun generateQuestion() {
        if (uiState.questionIndex < uiState.totalQuestions) {
            val (num1, num2) = questionsList[uiState.questionIndex]
            uiState = uiState.copy(
                currentQuestion = "$num1 + $num2 = ?",
                currentAnswer = ""
            )
        } else {
            finishGame()
        }
    }

    fun submitAnswer(answer: String) {
        val (num1, num2) = questionsList[uiState.questionIndex]
        val correctAnswer = num1 + num2

        if (answer.toIntOrNull() == correctAnswer) {
            uiState = uiState.copy(correctAnswers = uiState.correctAnswers + 1)
        } else {
            uiState = uiState.copy(wrongAnswers = uiState.wrongAnswers + 1)
        }

        uiState = uiState.copy(questionIndex = uiState.questionIndex + 1)
        // Check if the game is over (all questions answered)
        if (uiState.questionIndex >= uiState.totalQuestions) {
            finishGame()  // Call finishGame to mark the game as finished
        } else {
            generateQuestion()  // Generate the next question
        }
    }

    fun finishGame() {
        uiState = uiState.copy(isGameFinished = true)
    }

    fun resetGame() {
        startGame(uiState.totalQuestions)
    }
}
