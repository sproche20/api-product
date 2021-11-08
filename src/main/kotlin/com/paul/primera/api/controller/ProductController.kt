package com.paul.primera.api.controller

import com.paul.primera.api.Model.Product
import com.paul.primera.api.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/workouts")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])
class ProductController {
    @Autowired
    lateinit var ProductService: ProductService

    @GetMapping
    fun list(): List<Product>{
        return ProductService.list()
    }
}