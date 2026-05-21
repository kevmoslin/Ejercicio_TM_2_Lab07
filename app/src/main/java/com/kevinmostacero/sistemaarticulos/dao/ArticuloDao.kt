package com.kevinmostacero.sistemaarticulos.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kevinmostacero.sistemaarticulos.model.Articulo

@Dao
interface ArticuloDao {

    @Insert
    suspend fun insertar(
        articulo: Articulo
    )

    @Update
    suspend fun actualizar(
        articulo: Articulo
    )

    @Delete
    suspend fun eliminar(
        articulo: Articulo
    )

    @Query("SELECT * FROM articulos")
    suspend fun listarTodos(): List<Articulo>
}