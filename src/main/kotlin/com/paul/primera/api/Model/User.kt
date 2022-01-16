package com.paul.primera.api.Model

import javax.persistence.*

@Entity
@Table(name = "usuario")
class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var username: String?=null
    var password: String? = null
    var cedula:String?= null
}