package com.sena.biblioteca.ui.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetallesReservas(
    nombreLibro: String,
    fechaReserva: String,
    codigoReserva: String,
    onRenovar: () -> Unit,
    onCancelar: () -> Unit,
    onVolver: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Detalle de Reserva",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Libro: $nombreLibro",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text("Fecha de reserva: $fechaReserva")

                Spacer(modifier = Modifier.height(12.dp))

                Text("Código: $codigoReserva")

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Estado: Activa",
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onRenovar,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Renovar Reserva")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onCancelar,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error
            )
        ) {
            Text("Cancelar Reserva")
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
            onClick = onVolver,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}