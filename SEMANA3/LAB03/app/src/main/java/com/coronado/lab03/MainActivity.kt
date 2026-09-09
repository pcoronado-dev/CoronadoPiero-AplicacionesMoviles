package com.coronado.lab03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coronado.lab03.ui.theme.Lab03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab03Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaRegistro(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaRegistro(modifier: Modifier = Modifier) {

    var nombre by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var cantidad by remember { mutableStateOf("") }
    var mostrarResumen by remember { mutableStateOf(false) }

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {


            Text(
                text = "Nuevo producto",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = "Completa los datos y presiona Agregar",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.outline
            )

            Spacer(modifier = Modifier.height(24.dp))
            // aquí irán los campos de texto
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre del producto") }, modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = precio,
                onValueChange = { precio = it },
                label = {
                    Text("Precio (S/)")
                },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            OutlinedTextField(
                value = cantidad,
                onValueChange = { cantidad = it },
                label = {
                    Text("Cantidad")
                },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { mostrarResumen = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("AGREGAR PRODUCTO")
            }

            Spacer(modifier = Modifier.height(24.dp))

            if (mostrarResumen) {

                val precioNum = precio.toDoubleOrNull() ?: 0.0
                val cantidadNum = cantidad.toIntOrNull() ?: 0
                val importe = 0.0

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text(nombre, style = MaterialTheme.typography.titleLarge)

                        Text("Precio: S/ " + String.format("%.2f", precioNum))

                        Text("Cantidad: $cantidadNum")

                        Text(
                        "Importe: S/ " + String.format("%.2f", importe),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "✓ Producto registrado correctamente",
                    color = Color(0xFF2E7D32)
                )
            }
        }


    }
//GENERADO POR IA
//package com.example.registro // Mantén tu paquete original aquí
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun PantallaRegistro() {
//    // Estados para los campos del formulario
//    var nombre by remember { mutableStateOf("") }
//    var apellido by remember { mutableStateOf("") }
//    var correo by remember { mutableStateOf("") }
//    var telefono by remember { mutableStateOf("") }
//
//    // Estado para controlar el mensaje de error de validación
//    var mensajeError by remember { mutableStateOf<String?>(null) }
//
//    // Estado para almacenar la información procesada y mostrar la Card
//    var datosRegistrados by remember { mutableStateOf<DatosRegistro?>(null) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//            .verticalScroll(rememberScrollState()),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.spacedBy(12.dp)
//    ) {
//        Text(
//            text = "Registro de Usuario",
//            style = MaterialTheme.typography.headlineMedium
//        )
//
//        // Campos del Formulario
//        OutlinedTextField(
//            value = nombre,
//            onValueChange = {
//                nombre = it
//                if (mensajeError != null) mensajeError = null
//            },
//            label = { Text("Nombre") },
//            modifier = Modifier.fillMaxWidth(),
//            singleLine = true
//        )
//
//        OutlinedTextField(
//            value = apellido,
//            onValueChange = {
//                apellido = it
//                if (mensajeError != null) mensajeError = null
//            },
//            label = { Text("Apellido") },
//            modifier = Modifier.fillMaxWidth(),
//            singleLine = true
//        )
//
//        OutlinedTextField(
//            value = correo,
//            onValueChange = {
//                correo = it
//                if (mensajeError != null) mensajeError = null
//            },
//            label = { Text("Correo Electrónico") },
//            modifier = Modifier.fillMaxWidth(),
//            singleLine = true
//        )
//
//        OutlinedTextField(
//            value = telefono,
//            onValueChange = {
//                telefono = it
//                if (mensajeError != null) mensajeError = null
//            },
//            label = { Text("Teléfono") },
//            modifier = Modifier.fillMaxWidth(),
//            singleLine = true
//        )
//
//        // Mensaje de Error Visible si hay campos vacíos
//        mensajeError?.let { error ->
//            Text(
//                text = error,
//                color = MaterialTheme.colorScheme.error,
//                style = MaterialTheme.typography.bodyMedium,
//                modifier = Modifier.padding(vertical = 4.dp)
//            )
//        }
//
//        // Fila de Botones: AGREGAR y Limpiar
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            Button(
//                onClick = {
//                    // Validación de campos vacíos
//                    if (nombre.isBlank() || apellido.isBlank() || correo.isBlank() || telefono.isBlank()) {
//                        mensajeError = "Por favor, completa todos los campos del formulario."
//                    } else {
//                        // Si es válido, se oculta el error y se actualizan los datos de la Card
//                        mensajeError = null
//                        datosRegistrados = DatosRegistro(
//                            nombre = nombre,
//                            apellido = apellido,
//                            correo = correo,
//                            telefono = telefono
//                        )
//                    }
//                },
//                modifier = Modifier.weight(1f)
//            ) {
//                Text("AGREGAR")
//            }
//
//            OutlinedButton(
//                onClick = {
//                    // Reiniciar o vaciar todos los campos y el mensaje de error
//                    nombre = ""
//                    apellido = ""
//                    correo = ""
//                    telefono = ""
//                    mensajeError = null
//                    datosRegistrados = null
//                },
//                modifier = Modifier.weight(1f)
//            ) {
//                Text("Limpiar")
//            }
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Card que muestra la información registrada solo si NO hay errores
//        datosRegistrados?.let { datos ->
//            Card(
//                modifier = Modifier.fillMaxWidth(),
//                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//            ) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp),
//                    verticalArrangement = Arrangement.spacedBy(8.dp)
//                ) {
//                    Text(
//                        text = "Datos Registrados",
//                        style = MaterialTheme.typography.titleMedium
//                    )
//                    Text(text = "Nombre: ${datos.nombre} ${datos.apellido}")
//                    Text(text = "Correo: ${datos.correo}")
//                    Text(text = "Teléfono: ${datos.telefono}")
//                }
//            }
//        }
//    }
//}
//
//// Modelo simple de datos para representar la información del usuario
//data class DatosRegistro(
//    val nombre: String,
//    val apellido: String,
//    val correo: String,
//    val telefono: String
//)