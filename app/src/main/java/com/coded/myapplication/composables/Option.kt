package com.coded.myapplication.composables

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Option(text: String, modifier: Modifier = Modifier, callback: () -> Unit) {
    Button(
        onClick = callback,
        modifier = modifier
    ) {
        Text(
            text = text,
        )
    }
}
