package com.paul.primera.api.repository

import com.paul.primera.api.Model.Buses
import org.springframework.data.jpa.repository.JpaRepository

interface BusesRepository:JpaRepository<Buses,Long> {
    interface WorkoutRepository: JpaRepository<Buses, Long> {}
    fun findById(id: Long?): Buses?
}
