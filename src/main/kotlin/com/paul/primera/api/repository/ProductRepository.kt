package com.paul.primera.api.repository


import com.paul.primera.api.Model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository:JpaRepository<Product,Long> {
    interface WorkoutRepository:JpaRepository<Product, Long> {}
}
