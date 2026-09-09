package com.coronado.semana3tarea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coronado.semana3tarea.ui.theme.SEMANA3TAREATheme
import kotlin.math.roundToInt

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

    var redondear by remember { mutableStateOf(false) }

    var confirmado by remember { mutableStateOf(false) }

    var promedioCalculado by remember { mutableStateOf(false) }

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

        CursoSlider(
            nombre = "Fundamentos de Programación",
            peso = "20%",
            nota = notaFundamentos,

            onNotaChange = {
                notaFundamentos = it
                promedioCalculado = false
            }
        )

        CursoSlider(
            nombre = "Programación Orientada a Objetos",
            peso = "25%",
            nota = notaPOO,

            onNotaChange = {
                notaPOO = it
                promedioCalculado = false
            }
        )

        CursoSlider(
            nombre = "Programación en Móviles",
            peso = "30%",
            nota = notaMoviles,

            onNotaChange = {
                notaMoviles = it
                promedioCalculado = false
            }
        )

        CursoSlider(
            nombre = "Base de Datos",
            peso = "25%",
            nota = notaBD,

            onNotaChange = {
                notaBD = it
                promedioCalculado = false
            }
        )

        Row(
            modifier = Modifier.fillMaxWidth(),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Redondear promedio final",

                modifier = Modifier.weight(1f)
            )

            Switch(
                checked = redondear,

                onCheckedChange = {
                    redondear = it
                    promedioCalculado = false
                }
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = confirmado,

                onCheckedChange = {
                    confirmado = it
                }
            )

            Text(
                text = "Confirmo que las notas son correctas"
            )
        }

        Button(
            onClick = {

                promedioCalculado = true

            },

            enabled = confirmado,

            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "CALCULAR PROMEDIO"
            )
        }

        if (!promedioCalculado) {

            Text(
                text = "Asigna las notas y confirma para calcular",

                color = Color.Gray
            )

        } else {

            Resultado(
                notaFundamentos = notaFundamentos,
                notaPOO = notaPOO,
                notaMoviles = notaMoviles,
                notaBD = notaBD,
                redondear = redondear
            )
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "Desarrollado por: Piero Alexander Coronado Quispe",

            modifier = Modifier.fillMaxWidth()
        )

    }
}

@Composable
fun CursoSlider(
    nombre: String,
    peso: String,
    nota: Float,
    onNotaChange: (Float) -> Unit
) {

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "$nombre ($peso)",

                modifier = Modifier.weight(1f)
            )

            Box(
                modifier = Modifier
                    .background(
                        color = Color.Blue,

                        shape = RoundedCornerShape(8.dp)
                    )

                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            ) {

                Text(
                    text = nota.toInt().toString()
                )
            }
        }

        Slider(
            value = nota,

            onValueChange = onNotaChange,

            valueRange = 0f..20f,

            steps = 19
        )
    }
}

@Composable
fun Resultado(
    notaFundamentos: Float,
    notaPOO: Float,
    notaMoviles: Float,
    notaBD: Float,
    redondear: Boolean
) {

    val promedioPonderado = notaFundamentos * 0.20f + notaPOO * 0.25f + notaMoviles * 0.30f + notaBD * 0.25f

    val promedioFinal = if (redondear) {

        promedioPonderado.roundToInt().toFloat()

    } else { promedioPonderado }

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp),

            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {


            Text(
                text = "RESULTADOS",

                fontSize = 20.sp
            )


            // =========================
            // PROMEDIO PONDERADO
            // =========================

            Text(
                text = String.format(
                    "Promedio ponderado: %.2f",
                    promedioPonderado
                )
            )

            Text(

                text = if (redondear) {

                    "Promedio final: ${promedioFinal.toInt()} (redondeado)"

                } else {

                    String.format(
                        "Promedio final: %.2f",
                        promedioFinal
                    )
                }
            )
        }
    }
}



