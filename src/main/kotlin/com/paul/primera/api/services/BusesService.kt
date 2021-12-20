package com.paul.primera.api.services

import com.paul.primera.api.Model.Buses
import com.paul.primera.api.repository.BusesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.server.ResponseStatusException
@Service
class BusesService {
    @Autowired
    lateinit var BusesRepository: BusesRepository
    fun list(): List<Buses> {
        return BusesRepository.findAll()
    }

    @PostMapping
    fun save (buses: Buses): Buses {
        if (buses.marcas.equals("")){
            throw Exception()

        }else
        {
            return BusesRepository.save(buses)
        }
    }
    fun update(buses: Buses): Buses {
        return BusesRepository.save(buses)
    }

    fun updateDescription (buses: Buses): Buses{
        try{
            buses.marcas?.trim()?.isEmpty()
                ?:throw java.lang.Exception("la descripcion no puede estar vacio")
            if (buses.marcas.equals("")){
                throw throw java.lang.Exception("la descripcion no puede estar vacio")
            }
            val response = BusesRepository.findById(buses.id)
                ?: throw Exception()
            response.apply {
                this.marcas = buses.marcas
            }
            return BusesRepository.save(response)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, " NO HAY BUSES EN SERVICIO. ", ex)
        }
        }
    fun delete (id:Long): Boolean{
        BusesRepository.deleteById(id)
        return true
    }

}
