package valdez.ignacio.asignacion4_calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var et_altura:EditText = findViewById(R.id.et_altura);
        var et_peso:EditText = findViewById(R.id.et_peso);
        var btn_calcular:Button = findViewById(R.id.btn_calcular);
        var tv_resultado:TextView = findViewById(R.id.tv_resultado);

        btn_calcular.setOnClickListener {
            val altura = et_altura.text.toString().toDouble()/100;
            var peso = et_peso.text.toString().toDouble();
            var estado = obtenerEstado(calcularIMC(peso, altura));
            tv_resultado.text = estado;
            when(estado){
                "Peso bajo" -> tv_resultado.setBackgroundResource(R.color.brown)
                "Saludable" -> tv_resultado.setBackgroundResource(R.color.green)
                "Sobrepeso" -> tv_resultado.setBackgroundResource(R.color.greenish)
                "Obesidad de grado 1" -> tv_resultado.setBackgroundResource(R.color.yellow)
                "Obesidad de grado 2" -> tv_resultado.setBackgroundResource(R.color.orange)
                "Obesidad de grado 3" -> tv_resultado.setBackgroundResource(R.color.red)
            }
        }

    }

    fun calcularIMC(peso:Double = 1.0 , estatura:Double = 1.0):Double{
        return peso/(estatura*estatura);
    }

    fun obtenerEstado(imc:Double):String{
        var estado = "";
        when{
            imc < 18.5 -> return "Peso bajo"
            imc >= 18.5 &&  imc <= 24.9 -> return "Saludable"
            imc > 24.9 && imc <= 29.9 -> return "Sobrepeso"
            imc > 29.9 && imc <= 34.9 -> return "Obesidad de grado 1"
            imc > 34.9 && imc <= 39.9 -> return "Obesidad de grado 2"
            imc >= 40 -> return "Obesidad de grado 3"
        }
        return "error";
    }
}