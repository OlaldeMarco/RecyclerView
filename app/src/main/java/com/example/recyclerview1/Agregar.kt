package com.example.recyclerview1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_agregar.*
import kotlinx.android.synthetic.main.activity_main.*

class Agregar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)

        btnRegistrar.setOnClickListener(View.OnClickListener {
            val puestoUsuario= etPuesto.text.toString()
            val rfcUsuario=etRfc.text.toString()
            val depUsuario=etDep.text.toString()
            val intent= Intent()
            intent.putExtra("puestoUsuario", puestoUsuario)
            intent.putExtra("rfcUsuario", rfcUsuario)
            intent.putExtra("depUsuario", depUsuario)
            setResult(Activity.RESULT_OK,intent)
            finish()
        })
    }
}