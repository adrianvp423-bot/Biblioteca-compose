
package com.sena.biblioteca.ui.section

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InfoSection(
    autor: String,
    categoria: String,
    descripcion: String
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Autor: $autor")
            Spacer(Modifier.height(8.dp))
            Text("Categoría: $categoria")
            Spacer(Modifier.height(8.dp))
            Text("Descripción: $descripcion")
        }
    }
}
