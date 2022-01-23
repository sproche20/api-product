package com.paul.primera.api.service

import com.paul.primera.api.repository.UserRepository
import com.paul.primera.api.services.ChoferService
import com.paul.primera.api.services.UserService
import com.paul.primera.api.services.nuevUserService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest {



    @InjectMocks
    lateinit var nuevUserService: nuevUserService
    @Mock
    lateinit var userRepository: UserRepository

    @Test
    fun numeroIfIsPair(){
        val response=nuevUserService.numero(2,2)
        Assertions.assertEquals(4,response)
    }
    @Test
    fun numeroIfIsNotPair(){
        val response=nuevUserService.numero(1,2)
        Assertions.assertEquals(1,response)
    }
    @Test
    fun resnumIfIsMen(){
        
    }
    @Test
    fun createTeacher(){

    }








}