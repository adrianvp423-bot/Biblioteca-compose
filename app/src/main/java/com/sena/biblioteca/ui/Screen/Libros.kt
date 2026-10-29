package com.sena.biblioteca.ui.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Libros(
    onVerDetalle: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Mis Libros"
        )
        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = { onVerDetalle("Clean Code") }
        ) {
            Text(
                text = "Ver Detalle"
            )
        }
    }
}