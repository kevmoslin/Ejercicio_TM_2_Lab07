package com.kevinmostacero.sistemaarticulos

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.kevinmostacero.sistemaarticulos.model.Articulo
import com.kevinmostacero.sistemaarticulos.repository.ArticuloRepository
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var repository: ArticuloRepository

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val texto = TextView(this)

        texto.textSize = 18f

        setContentView(texto)

        val dao =
            AppDatabase
                .getDatabase(this)
                .articuloDao()

        repository =
            ArticuloRepository(dao)

        lifecycleScope.launch {

            repository.insertar(

                Articulo(
                    nombre = "Laptop",
                    descripcion = "Laptop HP",
                    precio = 3500.0
                )
            )

            repository.insertar(

                Articulo(
                    nombre = "Auriculares",
                    descripcion = "Auriculares Bluetooth",
                    precio = 180.0
                )
            )
        }

        lifecycleScope.launch {

            repeatOnLifecycle(
                Lifecycle.State.STARTED
            ) {

                repository
                    .listarTodos()
                    .collect { lista ->

                        texto.text =
                            lista.joinToString("\n\n") {

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