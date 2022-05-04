package com.example.notasdelestudiante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_notas.*

class notas : AppCompatActivity() {

    private lateinit var dbReference: DatabaseReference
    private lateinit var firebaseDatabase: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas)

        btnVerNota.setOnClickListener {

            NotaFinal()

        }

        btnGuardar.setOnClickListener {

            val materia = txtMateria.text.toString()
            val Computo = txtComputo.text.toString()
            val Nota1 = txtnota1.text.toString().toInt()
            val Nota2 = txtnota2.text.toString().toInt()
            val NotaPacial1 = txtnotaParcial.text.toString().toInt()
            val final = txtNotaFinal.text.toString()


            Guardar(materia,Computo,Nota1,Nota2,NotaPacial1,final)

            Toast.makeText(this,"SE HA GUARDADO EXITOSAMENTE",Toast.LENGTH_LONG).show()

        }

    }

    fun NotaFinal(){
        //val nombre= txtnombre.text.toString()

        val nota1 = txtnota1.text.toString().toInt()
        val nota2 = txtnota2.text.toString().toInt()
        val notaParcial = txtnotaParcial.text.toString().toInt()

        var uno = nota1 * 0.30
        var dos = nota2 * 0.30
        var parcial = notaParcial * 0.40

        var final = uno + dos + parcial

        txtNotaFinal.setText(""+ final)



    }

    fun Guardar(materia: String, Computo: String, Nota1: Int, Nota2: Int,NotaPacial1: Int, final: String) {
        val student = HashMap<String, String>()
        student["Materia "] = materia
        student["Computo "] = Computo
        student["Nota Laboratorio I "] = Nota1.toString()
        student["Nota Laboratorio II "] = Nota2.toString()
        student["Nota Parcial "] = NotaPacial1.toString()
        student["Nota Final: "] =  final

        val rootRef = FirebaseDatabase.getInstance().reference
        val tasksRef = rootRef.child("NOTAS").push()
        tasksRef.setValue(student)
    }

}
