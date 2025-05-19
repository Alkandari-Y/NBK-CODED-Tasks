package com.coded.myapplication.composables

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.coded.myapplication.R

@Composable
fun Answer(
    text: String,
    isCorrect: Boolean
) {
    Box(
        modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(percent = 50))
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            color = Color.White
        )

        Image(
            painter = painterResource(
                if (isCorrect) R.drawable.correct_answer else R.drawable.wrong_answer),
            contentDescription = "overlay image",
            modifier = if (isCorrect) Modifier
                .size(200.dp)
                .align(Alignment.Center) else Modifier
                    .size(100.dp)
                    .align(Alignment.TopCenter)
        )
    }
}