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
import com.sena.biblioteca.ui.Screen.MisReservas
import com.sena.biblioteca.ui.Screen.DetallesReservas
import com.sena.biblioteca.ui.Screen.RenovarReserva
import com.sena.biblioteca.ui.Screen.RenovacionExitosa

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

            val ruta = backStackEntry.toRoute<DetalleLibro>()

            DetallesLibros(
                nombreLibro = ruta.nombreLibro,

                onVolver = {
                    navController.popBackStack()
                },

                onReservar = { nombre ->

                    navController.navigate(
                        Confirmacion(
                            nombreLibro = nombre,
                            fecha = "15/06/2026"
                        )
                    )
                }
            )
        }


        composable<Confirmacion> { backStackEntry ->

            val ruta = backStackEntry.toRoute<Confirmacion>()

            Reservas(
                nombreLibro = ruta.nombreLibro,
                fecha = ruta.fecha,
                onIrMisReservas = {
                    navController.navigate(
                        MisReservasRoute(
                            nombreLibro = ruta.nombreLibro,
                            fechaReserva = ruta.fecha,
                            codigoReserva = "RES-2026-001"
                        )
                    )
                }
            )
        }

        composable<MisReservasRoute> { backStackEntry ->

            val ruta = backStackEntry.toRoute<MisReservasRoute>()

            MisReservas(
                nombreLibro = ruta.nombreLibro,
                fechaReserva = ruta.fechaReserva,
                codigoReserva = ruta.codigoReserva,
                activa = ruta.activa,

                onVerReserva = {
                    if (ruta.activa) {
                        navController.navigate(
                            DetalleReservaRoute(
                                nombreLibro = ruta.nombreLibro,
                                fechaReserva = ruta.fechaReserva,
                                codigoReserva = ruta.codigoReserva
                            )
                        )
                    }
                },

                onVolverInicio = {
                    navController.navigate(InicioBiblioteca) {
                        launchSingleTop = true
                    }
                }
            )
        }


        composable<DetalleReservaRoute> { backStackEntry ->

            val ruta = backStackEntry.toRoute<DetalleReservaRoute>()

            DetallesReservas(
                nombreLibro = ruta.nombreLibro,
                fechaReserva = ruta.fechaReserva,
                codigoReserva = ruta.codigoReserva,

                onRenovar = {
                    navController.navigate(
                        RenovarReservaRoute(
                            nombreLibro = ruta.nombreLibro,
                            fechaReserva = ruta.fechaReserva,
                            codigoReserva = ruta.codigoReserva
                        )
                    )
                },

                onCancelar = {
                    navController.navigate(
                        MisReservasRoute(
                            nombreLibro = ruta.nombreLibro,
                            fechaReserva = ruta.fechaReserva,
                            codigoReserva = ruta.codigoReserva,
                            activa = false
                        )
                    )
                },

                onVolver = {
                    navController.popBackStack()
                }
            )
        }


        composable<RenovarReservaRoute> { backStackEntry ->

            val ruta = backStackEntry.toRoute<RenovarReservaRoute>()

            RenovarReserva(
                nombreLibro = ruta.nombreLibro,
                fechaReserva = ruta.fechaReserva,

                onConfirmar = { fechaNueva ->

                    navController.navigate(
                        RenovacionExitosaRoute(
                            nombreLibro = ruta.nombreLibro,
                            fechaNueva = fechaNueva,
                            codigoReserva = ruta.codigoReserva
                        )
                    )
                },

                onVolver = {
                    navController.popBackStack()
                }
            )
        }


        composable<RenovacionExitosaRoute> { backStackEntry ->

            val ruta = backStackEntry.toRoute<RenovacionExitosaRoute>()

            RenovacionExitosa(
                nombreLibro = ruta.nombreLibro,
                fechaNueva = ruta.fechaNueva,

                onVolver = {
                    navController.navigate(
                        MisReservasRoute(
                            nombreLibro = ruta.nombreLibro,
                            fechaReserva = ruta.fechaNueva,
                            codigoReserva = ruta.codigoReserva,
                            activa = true
                        )
                    ) {
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}