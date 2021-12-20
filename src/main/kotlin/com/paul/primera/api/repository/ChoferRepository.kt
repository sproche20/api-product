package com.paul.primera.api.repository

import com.paul.primera.api.Model.Chofer
import org.springframework.data.jpa.repository.JpaRepository

interface ChoferRepository : JpaRepository<Chofer, Long> {
    interface WorkoutRepository: JpaRepository<Chofer, Long> {}
    fun findById(id: Long?): Chofer?
}