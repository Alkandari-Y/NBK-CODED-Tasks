package com.coded.myapplication.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun Question(
    text: String,
) {
    Text(
        text = text,
        fontSize = 30.sp,
    )

}