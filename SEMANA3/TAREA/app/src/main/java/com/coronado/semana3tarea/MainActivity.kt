package com.coronado.semana3tarea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coronado.semana3tarea.ui.theme.SEMANA3TAREATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SEMANA3TAREATheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegistroNotas(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RegistroNotas(modifier: Modifier = Modifier){

    var notaFundamentos by remember { mutableFloatStateOf(0f) }

    var notaPOO by remember { mutableFloatStateOf(0f) }

    var notaMoviles by remember { mutableFloatStateOf(0f) }

    var notaBD by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "Registro de Notas",
            fontSize = 28.sp
        )

        Text(
            text = "Asigna las notas de tus cursos",
            fontSize = 20.sp
        )
    }
}

