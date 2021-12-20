package com.paul.primera.api.repository

import com.paul.primera.api.Model.Buses
import com.paul.primera.api.Model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository:JpaRepository<User,Long> {
    fun findById(id: Long?): User?
    @Query(value = "SELECT * FROM USUARIO u WHERE u.username=:username", nativeQuery = true)
    fun findByIdUsername(username: String?): User?
}
