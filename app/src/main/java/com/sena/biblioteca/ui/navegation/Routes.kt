package com.sena.biblioteca.ui.navegation

import kotlinx.serialization.Serializable

@Serializable
data object  InicioBiblioteca

@Serializable
data object ListaLibros

@Serializable
data class DetalleLibro
    (val nombreLibro: String, )

@Serializable
data class Confirmacion( val nombreLibro: String,
                         val fecha:String)


