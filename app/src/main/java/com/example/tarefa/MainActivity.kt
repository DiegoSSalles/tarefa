package com.example.tarefa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

lateinit var edt_texto: EditText
lateinit var button_verificar: Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_verificar = findViewById(R.id.button_verificar)
        edt_texto = findViewById(R.id.edt_texto)

        botao()

        }

    fun checagem() {
        var tt = edt_texto.text
        when{
            edt_texto.text.toString() == "" ->  mostrarMensagem("este campo está vazio")
            edt_texto.text.equals(tt) -> mostrarMensagem("É do tipo String")
        }
    }
//
//    fun variaveis(){
//        var vazio = ""
//        var nulo = null
//        var emBranco = vazio.isBlank()
//        if(edt_texto.text.toString().equals(vazio)){
//            mostrarMensagem("este campo está vazio")
//        }else{
//            if(edt_texto.text.toString().equals(nulo)){
//                mostrarMensagem("este campo é nulo")
//            }else{
//                if (edt_texto.text.toString().equals(emBranco)){
//                    mostrarMensagem("este campo está em branco")
//                }
//            }
//        }
//    }

    fun botao(){
        button_verificar.setOnClickListener(){
            checagem()
        }
    }


    fun mostrarMensagem(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}


