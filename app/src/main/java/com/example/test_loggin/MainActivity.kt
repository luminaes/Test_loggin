package com.example.test_loggin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test_loggin.MainActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var user: EditText? = null
    var pass: EditText? = null
    var btnIngresar: Button? = null
    var btnRegistrar: Button? = null
    var dao: daoUsuarios? = null

    //Button btoReg; //declaro el boton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        user = findViewById<View>(R.id.editTextTextPersonName) as EditText
        pass = findViewById<View>(R.id.editTextTextPassword) as EditText
        btnIngresar = findViewById<View>(R.id.Ingresar) as Button
        btnRegistrar = findViewById<View>(R.id.ButtonReg) as Button
        btnIngresar!!.setOnClickListener(this)
        btnRegistrar!!.setOnClickListener(this)
        dao = daoUsuarios(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.Ingresar -> {
                val u = user!!.text.toString()
                val p = pass!!.text.toString()
                if (u == "" && p == "") {
                    Toast.makeText(this, "Campos Vacios", Toast.LENGTH_LONG).show()
                } else if (dao!!.login(u, p) == 1) { //revisar validacion
                    val ux = dao!!.getUsuario(u, p)
                    Toast.makeText(this, "LOGIN Exitoso", Toast.LENGTH_LONG).show()
                    val i2 = Intent(this@MainActivity, Menu::class.java)
                    i2.putExtra("id", ux.id) //paso ID del usuario logueado
                    startActivity(i2)
                }
            }
            R.id.ButtonReg -> {
                val i = Intent(this@MainActivity, Registrarse::class.java)
                startActivity(i)
            }
        }
    }
}