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

        if (chofer.chofers.equals("")){
            throw Exception()

        }else
        {
            return ChoferRepository.save(chofer)
        }

    }
    fun update(chofer: Chofer):Chofer {
        return ChoferRepository.save(chofer)
    }

    fun updateDescription (chofer: Chofer):Chofer{
        try{
            val response = ChoferRepository.findById(chofer.id)
                ?: throw Exception()
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
}