
package com.paul.primera.api.Model
import javax.persistence.*
@Entity
@Table(name = "Client")
class Client{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombre: String? = null


}