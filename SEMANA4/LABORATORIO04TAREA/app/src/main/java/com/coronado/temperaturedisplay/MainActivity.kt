package com.coronado.temperaturedisplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TemperatureDisplay()
        }
    }
}

@Composable
fun TemperatureDisplay() {

    var temperatura by remember { mutableStateOf(20) }
    val colorTexto = when {
        temperatura > 30 -> Color.Red
        temperatura < 10 -> Color.Blue
        else -> Color.Black
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Temperatura: $temperatura °C",
            color = colorTexto,
            fontSize = 28.sp
        )

        Row {

            Button(
                onClick = {
                    temperatura++
                }
            ) {
                Text("Subir")
            }

            Button(
                onClick = {
                    temperatura--
                }
            ) {
                Text("Bajar")
            }

            Button(
                onClick = {
                    temperatura = 20
                }
            ) {
                Text("Resetear")
            }
        }
    }
}
