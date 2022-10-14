package com.example.sqlite

class Notas {

    var notasID: Int?=null
    var titulo: String?=null
    var descripcion: String?=null

    constructor(notasID: Int,titulo:String,descripcion: String){

        this.notasID = notasID
        this.titulo = titulo
        this.descripcion = descripcion
    }
}