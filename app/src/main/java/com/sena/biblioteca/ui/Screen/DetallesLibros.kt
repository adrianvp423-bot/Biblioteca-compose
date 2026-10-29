
package com.sena.biblioteca.ui.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sena.biblioteca.R
import com.sena.biblioteca.ui.section.InfoSection
import com.sena.biblioteca.ui.section.ButtonSection

@Composable
fun DetallesLibros(
    nombreLibro: String,
    onVolver: () -> Unit,
    onReservar: (String) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Detalle del Libro",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.clean_code
                        ),
                        contentDescription = "Portada del libro $nombreLibro",
                        modifier = Modifier
                            .width(140.dp)
                            .height(190.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = nombreLibro,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    InfoSection(
                        autor = "Robert C. Martin",
                        categoria = "Programación",
                        descripcion = "Guía práctica para escribir código limpio, legible y mantenible."
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    ButtonSection(
                        texto = "Reservar Libro",
                        onClick = {
                            onReservar(nombreLibro)
                        }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedButton(
                        onClick = onVolver,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Volver a la lista")
                    }
                }
            }
        }
    }
}
