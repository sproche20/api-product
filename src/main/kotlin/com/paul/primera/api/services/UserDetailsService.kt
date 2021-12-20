package com.paul.primera.api.services

import com.paul.primera.api.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsService : UserDetailsService {
    @Autowired
    lateinit var userService: UserService
    override fun loadUserByUsername(username: String?): UserDetails {
        val response=userService.getUser(username)
        return User(response?.username,"{noop}"+response?.password, ArrayList())
    }
}