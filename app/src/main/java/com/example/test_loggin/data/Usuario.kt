package com.example.test_loggin.data

import androidx.room.Entity

@Entity(tableName = "Usuarios")
class Usuario {
    var id = 0
    var usuario: String? = null
    var password: String? = null
    var nombre: String? = null
    var correo: String? = null

    constructor() {}
    constructor(usuario: String?, password: String?, nombre: String?, correo: String?) {
        this.usuario = usuario
        this.password = password
        this.nombre = nombre
        this.correo = correo
    }

    val isNull: Boolean
        get() = nombre != "" || usuario != "" || correo != "" || password != ""

    override fun toString(): String {
        return "Usuario{" +
                "Id=" + id +
                ", Usuario='" + usuario + '\'' +
                ", Password='" + password + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Correo='" + correo + '\'' +
                '}'
    }
}