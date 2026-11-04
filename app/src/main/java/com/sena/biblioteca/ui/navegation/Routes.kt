package com.sena.biblioteca.ui.navegation

import kotlinx.serialization.Serializable

@Serializable
data object InicioBiblioteca

@Serializable
data object ListaLibros

@Serializable
data class DetalleLibro(val nombreLibro: String)

@Serializable
data class Confirmacion(
    val nombreLibro: String,
    val fecha: String
)

@Serializable
data class MisReservasRoute(
    val nombreLibro: String,
    val fechaReserva: String,
    val codigoReserva: String,
    val activa: Boolean = true
)

@Serializable
data class DetalleReservaRoute(
    val nombreLibro: String,
    val fechaReserva: String,
    val codigoReserva: String
)

@Serializable
data class RenovarReservaRoute(
    val nombreLibro: String,
    val fechaReserva: String,
    val codigoReserva: String
)

@Serializable
data class RenovacionExitosaRoute(
    val nombreLibro: String,
    val fechaNueva: String,
    val codigoReserva: String
)


