package com.kevinmostacero.sistemaarticulos

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.kevinmostacero.sistemaarticulos.model.Articulo
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val texto = TextView(this)

        texto.textSize = 18f

        setContentView(texto)

        db = AppDatabase.getDatabase(this)

        lifecycleScope.launch {

            db.articuloDao().insertar(

                Articulo(
                    nombre = "Monitor",
                    descripcion = "Monitor Samsung",
                    precio = 900.0
                )
            )

            db.articuloDao().insertar(

                Articulo(
                    nombre = "Mouse",
                    descripcion = "Mouse gamer",
                    precio = 120.0
                )
            )
        }

        lifecycleScope.launch {

            repeatOnLifecycle(
                Lifecycle.State.STARTED
            ) {

                db.articuloDao()
                    .listarTodos()
                    .collect { lista ->

                        texto.text = lista.joinToString("\n\n") {

                            "ID: ${it.id}\n" +
                                    "Nombre: ${it.nombre}\n" +
                                    "Descripción: ${it.descripcion}\n" +
                                    "Precio: S/ ${it.precio}"
                        }
                    }
            }
        }
    }
}