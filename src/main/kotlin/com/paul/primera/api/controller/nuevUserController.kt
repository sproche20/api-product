package com.paul.primera.api.controller

import com.paul.primera.api.Model.Chofer
import com.paul.primera.api.Model.User
import com.paul.primera.api.services.ChoferService
import com.paul.primera.api.services.nuevUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])
class nuevUserController {
    @Autowired
    lateinit var nuevUserService: nuevUserService
    @PostMapping
    fun save(@RequestBody user: User): User {
        return nuevUserService.save(user)
    }


}