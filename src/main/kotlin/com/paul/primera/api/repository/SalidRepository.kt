package com.paul.primera.api.repository

import com.paul.primera.api.Model.Salid
import org.springframework.data.jpa.repository.JpaRepository

interface SalidRepository : JpaRepository<Salid, Long> {
    interface WorkoutRepository: JpaRepository<Salid, Long> {}
    fun findById(id: Long?): Salid?
}