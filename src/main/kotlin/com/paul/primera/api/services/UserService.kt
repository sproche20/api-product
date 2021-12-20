package com.paul.primera.api.services

import com.paul.primera.api.Model.User
import com.paul.primera.api.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.server.ResponseStatusException

@Service
class UserService {
    @Autowired
    lateinit var userRepository: UserRepository
    fun list(): List<User> {
        return userRepository.findAll()
    }
    @PostMapping
    fun getUser (username: String?): User? {
        try {
            val response = userRepository.findByIdUsername(username)
                ?: throw Exception("no existe el usuario")
            return response
        }catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
        }
    fun update(user: User): User {
        return userRepository.save(user)

    }
    }
