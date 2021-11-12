package com.paul.primera.api.services

import com.paul.primera.api.Model.Client
import com.paul.primera.api.Model.Product
import com.paul.primera.api.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping

@Service

class ProductService {
    @Autowired
    lateinit var productRepository: ProductRepository
    fun list(): List<Product> {
        return productRepository.findAll()
    }
    @PostMapping
    fun save (product: Product): Product {
        return productRepository.save(product)
    }
    fun update(product: Product): Product {
        return productRepository.save(product)
    }

    fun updateDescription (product: Product): Product{
        val response = productRepository.findById(product.id)
            ?: throw Exception()
        response.apply {
            //this.description=client.description

        }
        return productRepository.save(response)
    }

    fun delete (id:Long): Boolean{
        productRepository.deleteById(id)
        return true
    }

}