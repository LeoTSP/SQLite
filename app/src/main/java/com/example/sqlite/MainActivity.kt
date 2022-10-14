package com.example.sqlite

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.core.content.getSystemService

class MainActivity  (var adapter: NotasAdapter?=null) : AppCompatActivity() {

    var listaDeNotas = ArrayList<Notas>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaDeNotas.add(Notas(1,"Primer Titulo","Primer Descripción"))
        listaDeNotas.add(Notas(2,"Segundo Titulo","Segundo Descripción"))
        listaDeNotas.add(Notas(3,"Tercer Titulo","Tercera Descripción"))

        adapter = NotasAdapter(this, listaDeNotas)
        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = adapter
    }

    class NotasAdapter(contexto: Context, var listaDeNotas: ArrayList<Notas>):BaseAdapter(){

        var contexto: Context?= contexto

        override fun getCount(): Int {
            return listaDeNotas.size
        }

        override fun getItem(position: Int): Any {
            return listaDeNotas[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val nota = listaDeNotas[position]

            val inflater = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val miVista = inflater.inflate(R.layout.molde_notas,null)

            miVista.findViewById<TextView>(R.id.textViewTitulo).setText(nota.titulo)
            miVista.findViewById<TextView>(R.id.textViewContenido).setText(nota.descripcion)

            return miVista
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val manuInflater: MenuInflater = menuInflater
        manuInflater.inflate(R.menu.menu, menu)

        val buscar = menu!!.findItem(R.id.app_bar_search).actionView as SearchView
        val manejador = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        buscar.setSearchableInfo(manejador.getSearchableInfo(componentName))
        buscar.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(applicationContext,query,Toast.LENGTH_LONG).show()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId){
            R.id.menuAgregar ->{
                var intent = Intent(this, AddActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    fun btnAdd(view: View){
        finish()
    }

}