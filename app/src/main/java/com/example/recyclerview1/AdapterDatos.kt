package com.example.recyclerview1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_datos.view.*

class AdapterDatos(private val datos :  ArrayList<Datos> = ArrayList() ): RecyclerView.Adapter<AdapterDatos.DatosViewHolder>() {
    class DatosViewHolder(view: View):RecyclerView.ViewHolder(view)

    fun agregarDato(tarea:Datos){
        datos.add(tarea)
        notifyItemInserted(itemCount)
    }

    // en esta funcion lo que hares es mandar a llamar el recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatosViewHolder {
        val view= LayoutInflater.from(parent.context)
            //Agarramos el layout y lo comvertimos en un objeto
            //y se agregue al objeo view
            //Creamos una jerarquia de objeto
            .inflate(R.layout.activity_datos,parent,false)
        return DatosViewHolder(view)
    }
    /*
    Lo que hace esta funcion es que tiene que debolver la
    cantidad de item en nuestro lista item
     */
    override fun getItemCount(): Int {
        return datos.size
    }

    override fun onBindViewHolder(holder: DatosViewHolder, position: Int) {
        holder.itemView.puesto.text=datos[position].puesto
        holder.itemView.rfc.text=datos[position].rfc
        holder.itemView.departamento.text=datos[position].departamento
    }


}