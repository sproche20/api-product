package com.paul.primera.api.services

import com.paul.primera.api.Model.Chofer
import com.paul.primera.api.repository.ChoferRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.server.ResponseStatusException
@Service
class ChoferService {
    @Autowired
    lateinit var ChoferRepository: ChoferRepository
    fun list(): List<Chofer> {
        return ChoferRepository.findAll()
    }
    @PostMapping
    fun save (chofer: Chofer):Chofer {
        try{
            chofer.chofers?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception()
            return ChoferRepository.save(chofer)
        }catch (ex:Exception){
            throw ex
        }


    }
    fun update(chofer: Chofer):Chofer {
        try{
            if(chofer.equals(" "))
            ChoferRepository.findById(chofer.id)
                ?:throw Exception()
            return ChoferRepository.save(chofer)
        }catch (ex:Exception){
            throw Exception()
        }

    }

    fun updateDescription (chofer: Chofer):Chofer{
        try{
            chofer.chofers?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception("agregar chofer")
            chofer.cedula?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception("agregar cedula")
            val response = ChoferRepository.findById(chofer.id)
                ?: throw Exception("tiene que existir los datos del chofer")
            response.apply {
                this.chofers=chofer.chofers

            }
            return ChoferRepository.save(response)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, "no existe el chofer", ex)
        }
    }
    fun delete (id:Long): Boolean{
        ChoferRepository.deleteById(id)
        return true
    }
    fun UpdateChoferIfPassedList(description: String): Boolean{
        val lista= listOf<String>("Pedro","Pablo","Mauricio");
        if (description.equals(lista)){
            return true
        }
        return false

    }
}