package com.paul.primera.api.Model

import javax.persistence.*

@Entity
@Table(name = "salid")
class Salid {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var salid: String?=null
    var horasal: String? = null
    var bus__id:Long?=null
    var ruta__id:Long?=null



}