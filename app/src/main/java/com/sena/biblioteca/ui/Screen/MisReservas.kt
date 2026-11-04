package com.sena.biblioteca.ui.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MisReservas(
    nombreLibro: String,
    fechaReserva: String,
    codigoReserva: String,
    activa: Boolean,
    onVerReserva: () -> Unit,
    onVolverInicio: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Mis Reservas",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (activa) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Lista de reservas activas")

                    Spacer(modifier = Modifier.height(16.dp))

                    Text("Libro: $nombreLibro")
                    Text("Fecha: $fechaReserva")
                    Text("Código: $codigoReserva")

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Activa",
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = onVerReserva,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Ver Reserva")
                    }
                }
            }
        } else {
            Text("No tienes reservas activas.")

            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = onVolverInicio,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver al Inicio")
        }
    }
}