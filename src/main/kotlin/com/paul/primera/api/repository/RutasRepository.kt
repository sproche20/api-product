package com.paul.primera.api.repository

import com.paul.primera.api.Model.Rutas
import org.springframework.data.jpa.repository.JpaRepository

interface RutasRepository: JpaRepository<Rutas, Long>  {
    interface WorkoutRepository: JpaRepository<Rutas, Long> {}
    fun findById(id: Long?): Rutas?
}