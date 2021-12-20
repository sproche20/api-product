package com.paul.primera.api.Model

import javax.persistence.*

@Entity
@Table(name = "rutas")

class Rutas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id:Long? = null
    var ruta: String? = null
    var tiempo: String? =null
}