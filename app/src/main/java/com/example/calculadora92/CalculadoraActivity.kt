package com.example.calculadora92

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

private lateinit var btnSumar: Button
private lateinit var btnRestar: Button
private lateinit var btnMultiplicar: Button
private lateinit var btnDividir: Button
private lateinit var btnLimpiar: Button
private lateinit var btnRegresar: Button
private lateinit var lblUsuario: TextView
private lateinit var lblResultado: TextView
private lateinit var txtNum1: EditText
private lateinit var txtNum2: EditText

// Declarar el objeto calculadora
private var calculadora = Calculadora(num1 = 0.0f, num2 = 0.0f)

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        iniciarComponentes()
        // Obtener los datos del MainActivity
        var datos = intent.extras
        var user = datos!!.getString("user")
        lblUsuario.text = user.toString()

        btnSumar.setOnClickListener { btnSumar() }
        btnRestar.setOnClickListener { btnRestar() }
        btnMultiplicar.setOnClickListener { btnMultiplicar() }
        btnDividir.setOnClickListener { btnDividir() }
        btnLimpiar.setOnClickListener { btnLimpiar() }
        btnRegresar.setOnClickListener { btnRegresar() }
    }

    private fun iniciarComponentes(){
        btnSumar = findViewById(R.id.btnSumar)
        btnRestar = findViewById(R.id.btnRestar)
        btnMultiplicar = findViewById(R.id.btnMultiplicar)
        btnDividir = findViewById(R.id.btnDividir)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnRegresar = findViewById(R.id.btnRegresar)
        lblUsuario = findViewById(R.id.lblUsuario)
        lblResultado = findViewById(R.id.lblResultado)
        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)
    }

    fun btnSumar(){
        calculadora.num1 = txtNum1.text.toString().toFloat()
        calculadora.num2 = txtNum2.text.toString().toFloat()
        val total = calculadora.suma()
        lblResultado.text = total.toString()
    }

    fun btnRestar(){
        calculadora.num1 = txtNum1.text.toString().toFloat()
        calculadora.num2 = txtNum2.text.toString().toFloat()
        val total = calculadora.resta()
        lblResultado.text = total.toString()
    }

    fun btnMultiplicar(){
        calculadora.num1 = txtNum1.text.toString().toFloat()
        calculadora.num2 = txtNum2.text.toString().toFloat()
        val total = calculadora.multiplicacion()
        lblResultado.text = total.toString()
    }

    fun btnDividir(){
        calculadora.num1 = txtNum1.text.toString().toFloat()
        calculadora.num2 = txtNum2.text.toString().toFloat()
        val total = calculadora.division()
        lblResultado.text = total.toString()
    }

    fun btnLimpiar(){
        lblResultado.text = ""
        txtNum1.setText("")
        txtNum2.setText("")
    }

    fun btnRegresar(){
        val confirmar = AlertDialog.Builder(this)
        confirmar.setTitle("Calculadora")
        confirmar.setMessage("Regresar al MainActivity?")
        confirmar.setPositiveButton("Confirmar") { dialogInterface, _ ->
            finish()
        }
        confirmar.setNegativeButton("Cancelar") { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        confirmar.show()
    }
}