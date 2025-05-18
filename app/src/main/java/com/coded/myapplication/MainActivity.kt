package com.coded.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coded.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->

                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(innerPadding)
                            .fillMaxSize()
                    ) {

                        Question(
                            text = "Android is an operating system", modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize()
                        )
                        Answer(
                            text = "Correct answer",
                            isCorrect = true
                        )

                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Option(text = "True", Modifier.width(200.dp))
                            Option(text = "False", Modifier.width(200.dp))
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun Question(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 30.sp,
    )

}

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


@Composable
fun Option(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        modifier = modifier
    ) {
        Text(
            text = text,
        )
    }
}
