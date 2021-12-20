package com.paul.primera.api.controller

import com.paul.primera.api.Model.Chofer
import com.paul.primera.api.services.ChoferService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("/chofer")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class ChoferController {
    @Autowired
    lateinit var ChoferService: ChoferService
    @GetMapping
    fun list(): List<Chofer>{
        return ChoferService.list()
    }
    @PostMapping
    fun save(@RequestBody chofer: Chofer): Chofer {
        return ChoferService.save(chofer)
    }
    @PutMapping
    fun update (@RequestBody chofer: Chofer): Chofer {
        return  ChoferService.update(chofer)
    }

    @PatchMapping
    fun updateDescription (@RequestBody chofer: Chofer): Chofer {
        return ChoferService.updateDescription(chofer)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return ChoferService.delete(id)
    }
}