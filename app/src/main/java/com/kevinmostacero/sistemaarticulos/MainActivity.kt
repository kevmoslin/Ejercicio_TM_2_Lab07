package com.kevinmostacero.sistemaarticulos

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.kevinmostacero.sistemaarticulos.model.Articulo
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val texto = TextView(this)

        setContentView(texto)

        db = AppDatabase.getDatabase(this)

        lifecycleScope.launch {

            val articulo1 = Articulo(
                nombre = "Laptop",
                descripcion = "Lenovo Core i5",
                precio = 3000.0
            )

            val articulo2 = Articulo(
                nombre = "Mouse",
                descripcion = "Mouse gamer",
                precio = 80.0
            )

            db.articuloDao().insertar(
                articulo1
            )

            db.articuloDao().insertar(
                articulo2
            )

            val lista =
                db.articuloDao()
                    .listarTodos()

            texto.text =
                lista.joinToString("\n\n") {

                    "ID: ${it.id}\n" +
                            "Nombre: ${it.nombre}\n" +
                            "Descripción: ${it.descripcion}\n" +
                            "Precio: ${it.precio}"
                }
        }
    }
}