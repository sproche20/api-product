package com.paul.primera.api.services
import com.paul.primera.api.Model.Product
import com.paul.primera.api.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping

@Service

class ProductService {
    @Autowired
    lateinit var ProductRepository: ProductRepository

    fun list(): List<Product> {

        return ProductRepository.findAll()
    }
    @PostMapping
    fun save(product: Product):Product {
        return ProductRepository.save(product)
    }
}