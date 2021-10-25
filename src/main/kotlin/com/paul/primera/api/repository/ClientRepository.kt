package com.paul.primera.api.repository

import com.paul.primera.api.Model.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository: JpaRepository<Client,Long> {
    interface WorkoutRepository:JpaRepository<Client, Long> {}
    fun findById(id: Long?): Client?
}