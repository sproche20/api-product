package com.paul.primera.api.service

import com.google.gson.Gson
import com.paul.primera.api.Model.Chofer
import com.paul.primera.api.repository.ChoferRepository
import com.paul.primera.api.services.ChoferService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class ChoferServiceTest {
    @InjectMocks
    lateinit var choferService: ChoferService

    @Mock
    lateinit var choferRepository: ChoferRepository

    val returnObject: Chofer = Chofer().apply {
        id= 1
        chofers="Pedro"
        cedula="010523897"
        licence=1256783
    }
    val newObject: Chofer = Chofer().apply {
        id = 1
        chofers = "Pedro"

    }

    @Test
    fun saveIsCorrect(){
        Mockito.`when`(choferRepository.save(Mockito.any(Chofer::class.java))).thenReturn(returnObject)
        val response = choferService.save(newObject)
        Assertions.assertEquals(response.id, newObject.id)
        Assertions.assertEquals(response.chofers, newObject.chofers)


    }


    val jsonString = File("./src/test/resources/chofer.json").readText(Charsets.UTF_8)
    val choferMock = Gson().fromJson(jsonString, Chofer::class.java)

    @Test
    fun createChofer(){
        Mockito.`when`(choferRepository.save(Mockito.any(Chofer::class.java))).thenReturn(choferMock)
        val response = choferService.save(choferMock)
        Assertions.assertEquals(response.id, choferMock.id)
        Assertions.assertEquals(response.chofers, choferMock.chofers)
        Assertions.assertEquals(response.cedula, choferMock.cedula)
    }
    @Test
    fun createChoferFailedWhenNameIsEntry(){
        Assertions.assertThrows(Exception::class.java) {
            choferMock.apply { chofers="    "}
            Mockito.`when`(choferRepository.save(Mockito.any(Chofer::class.java))).thenReturn(choferMock)
            choferService.save(choferMock)
        }
    }
    @Test
    fun updateIsCorrect(){
        Mockito.`when`(choferRepository.findById(newObject.id)).thenReturn(returnObject)
        Mockito.`when`(choferRepository.save(Mockito.any(Chofer::class.java))).thenReturn(returnObject)
        val response=choferService.update(newObject)
        Assertions.assertEquals(response.id,newObject.id)
        Assertions.assertEquals(response.chofers,newObject.chofers)
        Assertions.assertEquals(response.cedula, choferMock.cedula)



    }
    @Test
    fun updateIsNotExistedFailed(){
        Assertions.assertThrows(Exception::class.java){
            Mockito.`when`(choferRepository.findById(returnObject.id)).thenReturn(null)
            Mockito.`when`(choferRepository.save(Mockito.any(Chofer::class.java))).thenReturn(returnObject)
            choferService.update(choferMock)
        }

    }
    @Test
    fun updateIsFailedWhenDescriptionIsNull(){
        newObject.apply {
            chofers=" "
        }
        Mockito.`when`(choferRepository.findById(newObject.id)).thenReturn(returnObject)
        Mockito.`when`(choferRepository.save(Mockito.any(Chofer::class.java))).thenReturn(returnObject)
        val response= choferService.update(newObject)
        Assertions.assertEquals(response.id,newObject.id)
        Assertions.assertEquals(response.chofers,newObject.chofers)


    }

}