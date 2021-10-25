package com.paul.primera.api.services
import com.paul.primera.api.Model.Client
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.paul.primera.api.repository.ClientRepository
import org.springframework.web.bind.annotation.PostMapping

@Service
class ClientService {
    @Autowired
    lateinit var clientRepository:ClientRepository
    fun list(): List<Client> {
        return clientRepository.findAll()
    }
    @PostMapping
    fun save (client:Client):Client{
        return clientRepository.save(client)
    }
    fun update(client:Client):Client{
        return clientRepository.save(client)
    }

    fun updateDescription (client:Client):Client {
        val response = clientRepository.findById(client.id)
            ?: throw Exception()
        response.apply {
            //this.description=client.description

        }
        return clientRepository.save(response)
    }

    fun delete (id:Long): Boolean{
        clientRepository.deleteById(id)
        return true
    }

}