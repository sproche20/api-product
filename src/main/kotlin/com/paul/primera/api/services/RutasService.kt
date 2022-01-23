package com.paul.primera.api.services

import com.paul.primera.api.Model.Rutas
import com.paul.primera.api.repository.RutasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.server.ResponseStatusException
@Service
class RutasService {
    @Autowired
    lateinit var rutasRepository: RutasRepository
    fun list(): List<Rutas> {

        return rutasRepository.findAll()
    }
    @PostMapping
    fun save (rutas: Rutas):Rutas {
        try{
            rutas.ruta?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception()
                return rutasRepository.save(rutas)
        }catch (ex:Exception){
            throw ex
        }

    }
    fun update(rutas: Rutas):Rutas  {
        return rutasRepository.save(rutas)
    }
    fun updateDescription (rutas: Rutas):Rutas {
        
        try {
            if (rutas.ruta.equals("")) {
                throw Exception("ruta no encontrada")
            }
            val response = rutasRepository.findById(rutas.id)
                ?: throw Exception("la ruta N° ${rutas.id} no encontrada")
            response.apply {
                this.ruta = rutas.ruta
            }
            return rutasRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, "la ruta no existe", ex
            )
        }
    }
    fun delete (id:Long): Boolean{
        rutasRepository.deleteById(id)
        return true
    }

}