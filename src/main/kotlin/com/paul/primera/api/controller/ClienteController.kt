package com.paul.primera.api.controller
import com.paul.primera.api.Model.Client
import com.paul.primera.api.services.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/client")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class ClienteController {
    @Autowired
    lateinit var clientService: ClientService

    @GetMapping
    fun list(): List<Client> {
        return clientService.list()
    }
    @PostMapping
    fun save(client: Client): Client{
        return clientService.save(client)
    }
    @PutMapping
    fun update (@RequestBody client:Client): Client {
        return clientService.update(client)
    }

    @PatchMapping
    fun updateDescription (@RequestBody client:Client): Client{
        return clientService.updateDescription(client)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return clientService.delete(id)
    }

}