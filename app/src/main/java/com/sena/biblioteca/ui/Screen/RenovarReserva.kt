package com.sena.biblioteca.ui.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RenovarReserva(
    nombreLibro: String,
    fechaReserva: String,
    onConfirmar: (String) -> Unit,
    onVolver: () -> Unit
) {
    var fechaNueva by remember {
        mutableStateOf("30/06/2026")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Renovar Reserva",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text("Libro: $nombreLibro")

                Spacer(modifier = Modifier.height(16.dp))

                Text("Reserva actual: $fechaReserva")

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = fechaNueva,
                    onValueChange = {
                        fechaNueva = it
                    },
                    label = {
                        Text("Nueva fecha (DD/MM/AAAA)")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (fechaNueva.matches(
                        Regex("""\d{2}/\d{2}/\d{4}""")
                    )
                ) {
                    onConfirmar(fechaNueva)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirmar Renovación")
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