package com.paul.primera.api.services

import com.paul.primera.api.Model.Salid
import com.paul.primera.api.repository.BusesRepository
import com.paul.primera.api.repository.RutasRepository
import com.paul.primera.api.repository.SalidRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.server.ResponseStatusException
@Service
class SalidService {
    @Autowired
    lateinit var salidRepository: SalidRepository
    lateinit var busesRepository: BusesRepository
    lateinit var rutasRepository: RutasRepository
    fun list(): List<Salid> {
        return salidRepository.findAll()
    }
    @PostMapping
    fun save (salid: Salid):Salid {
        try{
            salid.horasal?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception()
            busesRepository.findById(salid.bus__id)
            rutasRepository.findById(salid.ruta__id)
            return salidRepository.save(salid)
        }catch (ex:Exception){
            throw ex
        }

    }
    fun update(salid: Salid): Salid {
        return salidRepository.save(salid)
    }

    fun updateDescription (salid: Salid): Salid{
        try{

            salid.salid?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception("agregar salida")
            val response = salidRepository.findById(salid.id)
                ?: throw Exception("tiene que existir ID ")


            response.apply {
                this.horasal=salid.horasal

            }
            busesRepository.findById(salid.bus__id)
            rutasRepository.findById(salid.ruta__id)
            return salidRepository.save(response)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, "no HAY SALIDA", ex)
        }

    }

    fun delete (id:Long): Boolean{
        salidRepository.deleteById(id)
        return true
    }
}