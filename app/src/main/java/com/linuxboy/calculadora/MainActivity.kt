package com.linuxboy.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var num1 : Double = 0.0
    private var num2 : Double = 0.0
    private var operacion : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cero_button.setOnClickListener { numeroPresionado("0") }
        uno_button.setOnClickListener { numeroPresionado("1") }
        dos_button.setOnClickListener { numeroPresionado("2") }
        tres_button.setOnClickListener { numeroPresionado("3") }
        cuatro_button.setOnClickListener { numeroPresionado("4") }
        cinco_button.setOnClickListener { numeroPresionado("5") }
        seis_button.setOnClickListener { numeroPresionado("6") }
        siete_button.setOnClickListener { numeroPresionado("7") }
        ocho_button.setOnClickListener { numeroPresionado("8") }
        nueve_button.setOnClickListener { numeroPresionado("9") }
        coma_button.setOnClickListener { numeroPresionado(".") }

        suma_button.setOnClickListener { operandoPresionado("+") }
        resta_button.setOnClickListener { operandoPresionado("-") }
        multip_button.setOnClickListener { operandoPresionado("*") }
        division_button.setOnClickListener { operandoPresionado("/") }


        limpiar_button.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            operacion = ""
            resultado_text_view.text = ""
        }

        igual_button.setOnClickListener {
            var resultado =
                if (operacion == "+") {
                    num1 + num2
                }else if (operacion == "-") {
                    num1 - num2
                }else if (operacion == "*") {
                    num1 * num2
                }else if (operacion == "/") {
                    num1 / num2
                }else 0
            resultado_text_view.text = resultado.toString()
        }


    }
    private fun operandoPresionado(operando: String){
        operacion = operando
        resultado_text_view.text = ""
    }

    private fun numeroPresionado (digito: String) {
        resultado_text_view.text = "${resultado_text_view.text}$digito"
        if (operacion == ""){
            num1 = resultado_text_view.text.toString().toDouble()
        }else {
            num2 = resultado_text_view.text.toString().toDouble()
        }
    }

    //private fun operacion (operacion: Int){}


}