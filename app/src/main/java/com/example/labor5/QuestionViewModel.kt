package com.example.labor5

import androidx.lifecycle.ViewModel


data class Question(
    val question: String,
    val a1: String,
    val a2: String,
    val a3: String,
    val a4: String,
    val correct: Int
)

class QuestionViewModel: ViewModel() {


    fun nextQuestion(): Question{
        return Question("How much is the fish?",
            "12 cents",
            "two dollars",
            "1000 FT",
        "22 oroszlan",
        2)
    }

}