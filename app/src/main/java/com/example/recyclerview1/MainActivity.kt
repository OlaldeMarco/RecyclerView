package com.example.recyclerview1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val agregarDatos = 1
    lateinit var adapterDatos: AdapterDatos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datos=ArrayList<Datos>()
        datos.add(Datos("Puesto","RFC", "Departamento"))

        adapterDatos=AdapterDatos(datos)
        recyclerV.adapter=adapterDatos
        recyclerV.layoutManager=LinearLayoutManager(this)

        btnAgregar.setOnClickListener(View.OnClickListener {
            startActivityForResult(Intent(this,Agregar::class.java),agregarDatos)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== agregarDatos){
            if(resultCode== Activity.RESULT_OK){
                val puestoUsuario=data!!.extras!!["puestoUsuario"] as String
                val rfcUsuario=data!!.extras!!["rfcUsuario"] as String
                val depUsuario=data!!.extras!!["depUsuario"] as String
                adapterDatos.agregarDato(Datos(puestoUsuario,rfcUsuario, depUsuario))

            }
        }
    }
}