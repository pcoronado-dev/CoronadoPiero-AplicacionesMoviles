package com.coronado.navegacion.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class StudentDetailInfo(
    val id: Int,
    val name: String,
    val career: String,
    val studentIdCode: String,
    val email: String,
    val faculty: String,
    val biography: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, itemId: Int) {
    val studentsMap = mapOf(
        1 to StudentDetailInfo(1, "Piero Coronado", "Diseño y Desarrollo de Software", "2026-0001", "piero.coronado@example.com", "Tecnologia Digital", "Estudiante destacado con interés en desarrollo Android."),
        2 to StudentDetailInfo(2, "María García", "Ingeniería de Software", "2026-0002", "maria.garcia@example.com", "Ingeniería", "Apasionada por la arquitectura de software y metodologías ágiles."),
        3 to StudentDetailInfo(3, "Carlos Pérez", "Redes y Seguridad", "2026-0003", "carlos.perez@example.com", "Tecnología Digital", "Especialista en infraestructura de redes y ciberseguridad defensiva."),
        4 to StudentDetailInfo(4, "Ana López", "Administración de Redes", "2026-0004", "ana.lopez@example.com", "Tecnología Digital", "Enfoque en gestión de redes y administración de sistemas."),
        5 to StudentDetailInfo(5, "Luis Torres", "Ciberseguridad", "2026-0005", "luis.torres@example.com", "Tecnología Digital", "Entusiasta de la seguridad informática y pentesting."),
        6 to StudentDetailInfo(6, "Sofia Mendoza", "Inteligencia Artificial", "2026-0006", "sofia.mendoza@example.com", "Tecnología e Innovación", "Investigación en machine learning y modelos de lenguaje."),
        7 to StudentDetailInfo(7, "Jorge Ramírez", "Desarrollo de Aplicaciones Móviles", "2026-0007", "jorge.ramirez@example.com", "Tecnología Digital", "Desarrollador multiplataforma especializado en Kotlin y Flutter."),
        8 to StudentDetailInfo(8, "Lucía Fernández", "Cloud Computing", "2026-0008", "lucia.fernandez@example.com", "Tecnología Digital", "Especialista en servicios Cloud AWS y arquitectura serverless.")
    )

    val student = studentsMap[itemId] ?: StudentDetailInfo(
        itemId,
        "Piero Coronado",
        "Diseño y Desarrollo de Software",
        "2026-%04d".format(itemId),
        "piero.coronado@example.com",
        "Tecnologia Digital",
        "Estudiante destacado con interés en desarrollo Android."
    )

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Expediente del Alumno",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = PurplePrimary)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(padding)
                .verticalScroll(scrollState)
        ) {
            // Header superior con degradado morado y esquinas inferiores redondeadas
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(PurplePrimary, PurpleLight)
                        ),
                        shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)
                    )
                    .padding(vertical = 32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Foto del estudiante dentro de un círculo blanco
                    Surface(
                        shape = CircleShape,
                        color = Color.White,
                        shadowElevation = 6.dp,
                        modifier = Modifier.size(90.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Surface(
                                shape = CircleShape,
                                color = PurplePrimary.copy(alpha = 0.15f),
                                modifier = Modifier.size(82.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(
                                        text = student.name.take(2).uppercase(),
                                        fontSize = 28.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = PurplePrimary
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = student.name,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = student.career,
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.85f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Datos del estudiante en bloque plano (Color(0xFFF3F3F3), elevation = 0.dp)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF3F3F3))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Text(
                            text = "Información Académica",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = PurplePrimary
                        )

                        HorizontalDivider(color = Color(0xFFE5E5E5))

                        DetailInfoItem(
                            icon = Icons.Default.Fingerprint,
                            label = "ID Estudiante",
                            value = student.studentIdCode
                        )

                        DetailInfoItem(
                            icon = Icons.Default.Email,
                            label = "Correo Electrónico",
                            value = student.email
                        )

                        DetailInfoItem(
                            icon = Icons.Default.School,
                            label = "Facultad",
                            value = student.faculty
                        )
                    }
                }

                // Sección de Biografía
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF3F3F3))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Biografía",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = PurplePrimary
                        )

                        HorizontalDivider(color = Color(0xFFE5E5E5))

                        Text(
                            text = student.biography,
                            fontSize = 14.sp,
                            color = TextGray,
                            lineHeight = 20.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun DetailInfoItem(icon: ImageVector, label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = PurplePrimary.copy(alpha = 0.1f),
            modifier = Modifier.size(42.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = PurplePrimary,
                    modifier = Modifier.size(22.dp)
                )
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = label,
                fontSize = 12.sp,
                color = TextGray
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = value,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1D1B20)
            )
        }
    }
}
