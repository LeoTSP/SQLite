package com.example.sqlite

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
    }

    fun btnAdd(view: View){
        val baseDatos = DBManager(this)

        val values = ContentValues()
        val editTextTextTitulo: EditText = findViewById(R.id.editTextTextTitulo)
        val editTextTextDescripcion: EditText = findViewById(R.id.editTextTextDescripcion)

            values.put("Titulo",editTextTextTitulo.text.toString())
            values.put("Titulo",editTextTextDescripcion.text.toString())

        val ID = baseDatos.insert(values)
        if (ID>0){
            Toast.makeText(this,"El registro se ingreso con éxito",Toast.LENGTH_LONG).show()
            finish()
        }else{
            Toast.makeText(this,"El registro no se realizo!",Toast.LENGTH_LONG).show()
        }
    }
}