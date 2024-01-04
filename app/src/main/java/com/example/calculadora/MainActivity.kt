package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.lang.Math.cos
import java.lang.Math.sin
import java.lang.Math.tan

class MainActivity : ComponentActivity() {
    //0-nada,1-suma,2-resta,3-multiplicación,4-división
    var oper: Int=0
    var numero1:Double = 0.0
    lateinit var textView: TextView
    lateinit var textView2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)

        val btnBorrar: Button = findViewById(R.id.btnBorrar)
        val btnIgual:Button=findViewById(R.id.btnigual)

        btnIgual.setOnClickListener{
            var numero2:Double = textView2.text.toString().toDouble()
            var resp:Double=0.0
            when (oper) {
                1 -> resp = numero1 + numero2
                2 -> resp = numero1 - numero2
                3 -> resp = numero1 * numero2
                4 -> resp = numero1 / numero2
                5 -> resp = sin(numero1)
                6 -> resp = cos(numero1)
                7 -> resp = tan(numero1)
            }
            textView2.setText(resp.toString())
            textView.setText("")
        }
        btnBorrar.setOnClickListener{
            textView.setText("")
            textView2.setText("")
            numero1=0.0
            oper=0
        }

    }

    fun sinc(x: Double): Double {
        return if (x != 0.0) {
            sin(x) / x
        } else {
            1.0 // Valor límite de sinc(x) cuando x tiende a 0
        }
    }

    fun presionarDigito(view: View) {
        var num2: String = textView2.text.toString()

        when (view.id) {
            R.id.btn0 -> textView2.setText(num2 + "0")
            R.id.btn1 -> textView2.setText(num2 + "1")
            R.id.btn2 -> textView2.setText(num2 + "2")
            R.id.btn3 -> textView2.setText(num2 + "3")
            R.id.btn4 -> textView2.setText(num2 + "4")
            R.id.btn5 -> textView2.setText(num2 + "5")
            R.id.btn6 -> textView2.setText(num2 + "6")
            R.id.btn7 -> textView2.setText(num2 + "7")
            R.id.btn8 -> textView2.setText(num2 + "8")
            R.id.btn9 -> textView2.setText(num2 + "9")
            R.id.btnPunto -> textView2.setText(num2 + ".")
            R.id.btn_suma -> textView2.setText(num2+"+")
            R.id.btn_resta -> textView2.setText(num2+"-")
            R.id.btnmultiplicar -> textView2.setText(num2+"*")
            R.id.btndividir -> textView2.setText(num2+"/")
            R.id.btnigual -> textView2.setText(num2)
            R.id.btnsin -> textView2.setText(num2)
            R.id.btncos -> textView2.setText(num2)
            R.id.btntan -> textView2.setText(num2)
        }
    }
    fun clickOperacion(view:View){
        numero1 = textView2.text.toString().toDouble()
        var num2:String=textView2.text.toString()
        textView2.setText("")
        when(view.id){
            R.id.btn_suma->{
                textView.setText(num2 + "+")
                oper = 1
            }
            R.id.btn_resta->{
                textView.setText(num2 + "-")
                oper = 2
            }
            R.id.btnmultiplicar->{
                textView.setText(num2 + "*")
                oper = 3
            }
            R.id.btndividir->{
                textView.setText(num2 + "/")
                oper = 4
            }
            R.id.btnsin->{
                textView.setText(num2 + "sin")
                oper = 5
            }
            R.id.btncos->{
                textView.setText(num2 + "cos")
                oper = 6
            }
            R.id.btntan->{
                textView.setText(num2 + "tan")
                oper = 7
            }
        }
    }

}








