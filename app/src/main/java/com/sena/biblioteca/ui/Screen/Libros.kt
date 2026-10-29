
package com.sena.biblioteca.ui.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.biblioteca.ui.section.BookCardSection

@Composable
fun Libros(
    onVerDetalle: (String) -> Unit
) {
    val libros = listOf(
        "Clean Code",
        "Kotlin para Android",
        "Arquitectura de Software",
        "Jetpack Compose"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Mis Libros",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(libros) { libro ->
                BookCardSection(
                    nombre = libro,
                    onVerDetalle = {
                        onVerDetalle(libro)
                    }
                )
            }
        }
    }
}
