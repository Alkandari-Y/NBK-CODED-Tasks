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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coded.myapplication.R

@Composable
fun Result(scoreState: String) {
    Text(
        text = stringResource(R.string.your_score),
        textAlign = TextAlign.Center,
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        fontSize = 60.sp
    )
    Box(
        modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(percent = 50))
            .background(Color.Green),
        contentAlignment = Alignment.Center,

        ) {
        Text(
            text = scoreState,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 60.sp
        )
    }
}