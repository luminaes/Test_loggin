package com.example.test_loggin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.test_loggin.data.Usuario
import java.util.*

class daoUsuarios(var c: Context) {
    var u: Usuario
    var lista: ArrayList<Usuario>? = null
    var sql: SQLiteDatabase
    var bd = "BDUsuarios"
    var tabla = "create table if not exists usuario(id integer primary key autoincrement, usuario text,pass text, nom text, correo text)"
    fun insertUsuario(u: Usuario): Boolean {
        return if (buscar(u.usuario) == 0) {
            val cv = ContentValues()
            cv.put("usuario", u.usuario)
            cv.put("pass", u.password)
            cv.put("nom", u.nombre)
            cv.put("correo", u.correo)
            sql.insert("usuario", null, cv) > 0
        } else {
            false
        }
    }

    fun buscar(u: String?): Int {
        var x = 0
        lista = selectUsuarios()
        for (us in lista!!) if (u == us.usuario) {
            x++
        }
        return x
    }

    fun selectUsuarios(): ArrayList<Usuario> {  //selccionar todos los usuarion en la base de datos
        val lista = ArrayList<Usuario>()
        lista.clear()
        val cr = sql.rawQuery("select * from usuario", null)
        if (cr != null && cr.moveToFirst()) {
            do {
                val u = Usuario()
                u.id = cr.getInt(0)
                u.usuario = cr.getString(1)
                u.password = cr.getString(2)
                u.nombre = cr.getString(3)
                u.correo = cr.getString(4)
                lista.add(u)
            } while (cr.moveToNext())
        }
        return lista
    }

    fun login(u: String, p: String): Int {
        var a = 0
        val cr = sql.rawQuery("select * from usuario", null)
        if (cr != null && cr.moveToFirst()) { //if() (cr == null || !cr.moveToFirst())
            do if (cr.getString(1) == u && cr.getString(2) == p) { //if (cr.getString(1).equals(u)&& cr.getString(2).equals(p)
                a++
            } while (cr.moveToNext())
        }
        return a
    }

    fun getUsuario(u: String, p: String): Usuario? {
        lista = selectUsuarios()
        for (us in lista!!) {
            if (us.usuario == u && us.password == p) {
                return us
            }
        }
        return null
    }

    fun getUsuarioById(id: Int): Usuario? {
        lista = selectUsuarios()
        for (us in lista!!) {
            if (us.id == id) {
                return us
            }
        }
        return null
    }

    //create en el helper
    init {
        sql = c.openOrCreateDatabase(bd, Context.MODE_PRIVATE, null)
        sql.execSQL(tabla)
        u = Usuario()
    }
}