package com.coded.myapplication.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Answer(
    text: String,
    isCorrect: Boolean
) {

    Box(
        modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(percent = 50))
            .background(if (isCorrect) Color.Green else Color.Red),
        contentAlignment = Alignment.Center,

        ) {
        Text(
            text = text,
            textAlign = TextAlign.Center

        )
    }
}