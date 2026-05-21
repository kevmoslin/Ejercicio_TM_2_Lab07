package com.kevinmostacero.sistemaarticulos.repository

import com.kevinmostacero.sistemaarticulos.dao.ArticuloDao
import com.kevinmostacero.sistemaarticulos.model.Articulo

class ArticuloRepository(

    private val dao: ArticuloDao
) {

    fun listarTodos() =
        dao.listarTodos()

    suspend fun insertar(
        articulo: Articulo
    ) {

        dao.insertar(articulo)
    }

    suspend fun actualizar(
        articulo: Articulo
    ) {

        dao.actualizar(articulo)
    }

    suspend fun eliminar(
        articulo: Articulo
    ) {

        dao.eliminar(articulo)
    }
}