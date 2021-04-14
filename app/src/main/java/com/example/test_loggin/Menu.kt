package com.example.test_loggin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test_loggin.data.Usuario

class Menu : AppCompatActivity() {
    var id = 0
    var u: Usuario? = null
    var dao: daoUsuarios? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val b = intent.extras
        id = b!!.getInt("id")
        dao = daoUsuarios(this)
        u = dao!!.getUsuarioById(id)
    }
}