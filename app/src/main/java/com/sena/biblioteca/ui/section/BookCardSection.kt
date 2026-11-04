
package com.sena.biblioteca.ui.section

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BookCardSection(
    nombre: String,
    onVerDetalle: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "📘",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(Modifier.width(12.dp))

            Text(
                text = nombre,
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.SemiBold
            )

            TextButton(onClick = onVerDetalle) {
                Text("Ver Detalle")
            }
        }
    }
}
