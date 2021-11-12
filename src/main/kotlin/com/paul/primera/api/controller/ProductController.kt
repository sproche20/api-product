package com.paul.primera.api.controller

import com.paul.primera.api.Model.Client
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
    @PostMapping
    fun save(product:Product): Product {
        return ProductService.save(product)
    }
    @PutMapping
    fun update (@RequestBody product:Product): Product {
        return ProductService.update(product)
    }

    @PatchMapping
    fun updateDescription (@RequestBody product:Product): Product {
        return ProductService.updateDescription(product)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return ProductService.delete(id)
    }

}