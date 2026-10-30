package com.sena.biblioteca.ui.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.sena.biblioteca.ui.Screen.Home
import com.sena.biblioteca.ui.Screen.Libros
import com.sena.biblioteca.ui.Screen.DetallesLibro
import com.sena.biblioteca.ui.Screen.Reservas

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = InicioBiblioteca
    ) {

        composable<InicioBiblioteca> {
            Home(onirLibros = {
                navController.navigate(ListaLibros)
            })
        }

        composable<ListaLibros> {
            Libros(
                onverDetalle = { nombreLibro ->

                    navController.navigate(DetalleLibroRoute(nombreLibro))
                }
            )
        }

        composable<DetalleLibroRoute> { backStackEntry ->
            val route: DetalleLibroRoute = backStackEntry.toRoute()
            DetallesLibros(
                nombreLibro = route.nombreLibro,
                onVolver = {
                    navController.popBackStack()
                }
            )
        }
    }
}


