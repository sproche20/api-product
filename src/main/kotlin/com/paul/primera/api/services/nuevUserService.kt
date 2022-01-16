package com.paul.primera.api.services

import com.paul.primera.api.Model.Chofer
import com.paul.primera.api.Model.User
import com.paul.primera.api.controller.nuevUserController
import com.paul.primera.api.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
@Service

class nuevUserService {
    @Autowired
    lateinit var userRepository: UserRepository
    fun list(): List<User> {
        return userRepository.findAll()
    }
    @PostMapping
    fun save (user:User):User {

        if (user.cedula.equals("")){
            throw Exception()

        }else
        {
            return userRepository.save(user)
        }
    }
    fun numero(index:Int, number: Int):Int{
        if (index %2==0){
            var resultado=index*2
            return resultado
        }
        else{
            var resultado=index*1
            return resultado
        }
    }
    fun resnum(number: Int):Int{
        if (number>=10&& number<=18){
            return number-9
        }
        return number
    }


}