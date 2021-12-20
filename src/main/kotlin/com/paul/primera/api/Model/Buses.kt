package com.paul.primera.api.Model

import javax.persistence.*

@Entity
@Table(name = "buses")
class Buses {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var marcas: String? = null
    var placas: String?= null
    var pasageros: Long?= null
}