package com.paul.primera.api.Model

import javax.persistence.*

@Entity
@Table(name = "chofer")
class Chofer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var chofers: String? = null
    var cedula: String?= null
    var licence: Int?= null
}