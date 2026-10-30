package com.sena.biblioteca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sena.biblioteca.ui.navegation.AppNavigation
import com.sena.biblioteca.ui.theme.BibliotecaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BibliotecaTheme {
                AppNavigation()
            }
        }
    }
}