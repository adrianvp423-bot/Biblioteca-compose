
package com.sena.biblioteca.ui.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.sena.biblioteca.ui.Screen.Home
import com.sena.biblioteca.ui.Screen.Libros
import com.sena.biblioteca.ui.Screen.DetallesLibros
import com.sena.biblioteca.ui.Screen.Reservas

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = InicioBiblioteca
    ) {

        composable<InicioBiblioteca> {
            Home(
                onIrLibros = {
                    navController.navigate(ListaLibros)
                }
            )
        }

        composable<ListaLibros> {
            Libros(
                onVerDetalle = { nombreLibro ->
                    navController.navigate(
                        DetalleLibro(nombreLibro)
                    )
                }
            )
        }

        composable<DetalleLibro> { backStackEntry ->

            val route = backStackEntry.toRoute<DetalleLibro>()

            DetallesLibros(
                nombreLibro = route.nombreLibro,

                onVolver = {
                    navController.popBackStack()
                },

                onReservar = { nombre ->
                    navController.navigate(
                        Confirmacion(
                            nombreLibro = nombre,
                            fecha = "29/10/2026"
                        )
                    )
                }
            )
        }

        composable<Confirmacion> { backStackEntry ->

            val route = backStackEntry.toRoute<Confirmacion>()

            Reservas(
                nombreLibro = route.nombreLibro,
                fecha = route.fecha,

                onVolverInicio = {
                    navController.navigate(InicioBiblioteca) {
                        popUpTo<InicioBiblioteca> {
                            inclusive = false
                        }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
