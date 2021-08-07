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

        //equals ==
        // tentar converter o tipo, e em seguide verificar se este tipo confere com algum tipo esperado
        val editValor = edt_texto.text.toString()

        val retornoChecagemInteiro = testaInteiro(editValor)
        val retornoChecagemString = testaString(editValor)
        val retornoChecagemBoolean = testaBoolean(editValor)

        when{
            retornoChecagemInteiro -> {
                mostrarMensagem("Não é um valor string")
                mostrarMensagem("Não é um valor Booleano")
                mostrarMensagem("É um valor inteiro")
            }
            retornoChecagemString -> {
                mostrarMensagem("Não é um valor inteiro")
                mostrarMensagem("Não é um valor Booleano")
                mostrarMensagem("É um valor string")
            }
            retornoChecagemBoolean -> {
                mostrarMensagem("Não é um valor inteiro")
                mostrarMensagem("Não é um valor string")
                mostrarMensagem("É um valor Booleano")
            }
            else -> {
                mostrarMensagem("Valor Desconhecido")
            }
        }

    }
    private fun testaInteiro(edt: String): Boolean{
        return try {
            val valorConvertido = edt.toInt()
            true
        }catch (e: Exception){
            false
        }
    }

    private fun testaString(edt: String): Boolean{
        return edt.startsWith("\"") && edt.endsWith("\"")
    }

    private fun testaBoolean(edt: String): Boolean{
        return try {
            val stringToBoolean = edt.toBooleanStrict()
            true
        }catch (e: Exception){
            false
        }
    }

    fun botao(){
        button_verificar.setOnClickListener(){
            tarefa2(edt_texto.text.toString())
        }
    }

    //identificar em uma variavel a diferença entre vazio, null, e em branco e mostrar em uma mensagem
    // diferença vazio e embranco, vazio = "" e em branco "    "
    private fun tarefa2(edt: String? = null) {

        if (edt != null) {
            when{
                edt.isEmpty() -> mostrarMensagem("o campo está vazio")
                edt.isBlank() -> mostrarMensagem("o campo está em branco")
                else -> checagem()
            }
        }
    }


    fun mostrarMensagem(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}


