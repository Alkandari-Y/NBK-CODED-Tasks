package com.coded.myapplication.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.coded.myapplication.R

@Composable
fun QuestionGame(modifier: Modifier = Modifier) {
    val questions = stringArrayResource(R.array.questions).map {
        val parts = it.split("|")
        Pair(parts.first(), parts.last().toBoolean())
    }

    var userInputState by remember { mutableStateOf<Boolean?>(null) }
    var currentIndexState by remember { mutableIntStateOf(0) }
    var scoreState by remember { mutableIntStateOf(0) }

    val isQuizFinished = currentIndexState >= questions.size
    val currentQuestion = if (!isQuizFinished) questions[currentIndexState] else null
    val isCorrectAnswer = userInputState != null && userInputState == currentQuestion?.second

    Column(
        verticalArrangement = if (isQuizFinished) Arrangement.Center else Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {

        if (isQuizFinished) {
            Result(scoreState = scoreState.toString())
        }

        if (!isQuizFinished && currentQuestion != null) {
            Question(
                text = currentQuestion.first,
            )


            if (userInputState != null) {
                Answer(
                    text = if (isCorrectAnswer) stringResource(R.string.correct_answer) else stringResource(
                        R.string.incorrect_answer
                    ),
                    isCorrect = isCorrectAnswer
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                if (userInputState != currentQuestion.second) {
                    Option(text = "True", Modifier.width(200.dp)) {
                        userInputState = true
                    }
                    Option(
                        text = "False", Modifier.width(200.dp)
                    ) {
                        userInputState = false

                    }
                }
                if (isCorrectAnswer && currentIndexState < questions.size) {
                    Option(
                        text = stringResource(R.string.next_question),
                        Modifier.fillMaxWidth()
                    ) {
                        userInputState = null
                        scoreState += 1
                        currentIndexState += 1

                    }
                }
            }
        }
    }
}