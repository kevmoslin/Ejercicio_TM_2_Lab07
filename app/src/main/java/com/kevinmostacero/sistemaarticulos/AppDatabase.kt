package com.kevinmostacero.sistemaarticulos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kevinmostacero.sistemaarticulos.dao.ArticuloDao
import com.kevinmostacero.sistemaarticulos.model.Articulo

@Database(
    entities = [Articulo::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articuloDao(): ArticuloDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context
        ): AppDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "articulos_db"
                    ).build()

                INSTANCE = instance

                instance
            }
        }
    }
}