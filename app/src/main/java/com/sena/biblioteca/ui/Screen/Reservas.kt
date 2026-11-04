package com.sena.biblioteca.ui.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Reservas(
    nombreLibro: String,
    fecha: String,
    onIrMisReservas: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "¡Reserva Exitosa!",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Libro: $nombreLibro")
        Text("Fecha: $fecha")

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onIrMisReservas) {
            Text("Ver Mis Reservas")
        }
    }
}