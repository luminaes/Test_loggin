package com.example.test_loggin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test_loggin.Registrarse
import com.example.test_loggin.data.Usuario

class Registrarse : AppCompatActivity(), View.OnClickListener {
    var us: EditText? = null
    var pas: EditText? = null
    var nom: EditText? = null
    var cor: EditText? = null
    var reg: Button? = null
    var can //registrar y cancelar
            : Button? = null
    var dao: daoUsuarios? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)
        us = findViewById<View>(R.id.Reguser) as EditText
        nom = findViewById<View>(R.id.RegNombre) as EditText
        cor = findViewById<View>(R.id.RegCorreo) as EditText
        pas = findViewById<View>(R.id.RegPassword) as EditText
        reg = findViewById<View>(R.id.btnReg) as Button
        can = findViewById<View>(R.id.btnRegCancel) as Button
        can!!.setOnClickListener(this)
        reg!!.setOnClickListener(this)
        dao = daoUsuarios(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnReg -> {
                val u = Usuario()
                u.usuario = us!!.text.toString()
                u.nombre = nom!!.text.toString()
                u.correo = cor!!.text.toString()
                u.password = pas!!.text.toString()
                if (!u.isNull) {
                    Toast.makeText(this, "Error Campos incompletos", Toast.LENGTH_LONG).show()
                } else if (dao!!.insertUsuario(u)) {
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_LONG).show()
                }
            }
            R.id.btnRegCancel -> {
                val i = Intent(this@Registrarse, MainActivity::class.java)
                startActivity(i)
                finish()
            }
        }
    }
}