package com.example.calculadora92

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var btnIngresar: Button
    private lateinit var btnSalir: Button
    private lateinit var txtUsuario: TextInputEditText
    private lateinit var txtContrasena: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciarComponentes()
        btnIngresar.setOnClickListener { btnIngresar() }
        btnSalir.setOnClickListener { btnSalir() }
    }

    private fun iniciarComponentes(){
        btnIngresar = findViewById(R.id.btnIngresar)
        btnSalir = findViewById(R.id.btnSalir)
        txtUsuario = findViewById(R.id.txtUsuario)
        txtContrasena = findViewById(R.id.txtContrasena)
    }

   private fun btnIngresar(){
        var strUsuario: String
        var strContrasena: String

        strUsuario = applicationContext.resources.getString(R.string.user)
        strContrasena = applicationContext.resources.getString(R.string.password)
        if (strUsuario.toString().equals(txtUsuario.text.toString()) && strContrasena.toString().equals(txtContrasena.text.toString())){
            var bundle = Bundle();
            bundle.putString("user", txtUsuario.text.toString())

            var intent = Intent(this@MainActivity, CalculadoraActivity::class.java)
            intent.putExtras(bundle)

            startActivity(intent)
        }else{
            Toast.makeText(this.applicationContext, "El usuario o contraseña no es válido", Toast.LENGTH_SHORT).show()
        }
    }

    private fun btnSalir(){
        val confirmar = AlertDialog.Builder(this)
        confirmar.setTitle("Calculadora")
        confirmar.setMessage("Cerrar la aplicación?")
        confirmar.setPositiveButton("Confirmar") { dialogInterface, _ ->
            finish()
        }
        confirmar.setNegativeButton("Cancelar") { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        confirmar.show()
    }
}