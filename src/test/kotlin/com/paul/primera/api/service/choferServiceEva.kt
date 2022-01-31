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
class choferServiceEva {
    @InjectMocks
    lateinit var choferService: ChoferService

    @Mock
    lateinit var choferRepository: ChoferRepository

    val jsonString = File("./src/test/resources/chofer.json").readText(Charsets.UTF_8)
    val choferMock = Gson().fromJson(jsonString, Chofer::class.java)

    @Test
    fun updateIsCorrect(){
        Mockito.`when`(choferRepository.findById(choferMock.id)).thenReturn(choferMock)
        Mockito.`when`(choferRepository.save(Mockito.any(Chofer::class.java))).thenReturn(choferMock)
        val response=choferService.update(choferMock)
        Assertions.assertEquals(response.id,choferMock.id)
        Assertions.assertEquals(response.chofers,choferMock.chofers)
        Assertions.assertEquals(response.cedula, choferMock.cedula)



    }
    @Test
    fun updateIsNotExistedFailed(){
        Assertions.assertThrows(Exception::class.java){
            Mockito.`when`(choferRepository.findById(choferMock.id)).thenReturn(null)
            Mockito.`when`(choferRepository.save(Mockito.any(Chofer::class.java))).thenReturn(choferMock)
            choferService.update(choferMock)
        }

    }
    @Test
    fun updateIsFailedWhenDescriptionIsNull(){
        choferMock.apply {
            chofers=" "
        }
        Mockito.`when`(choferRepository.findById(choferMock.id)).thenReturn(choferMock)
        Mockito.`when`(choferRepository.save(Mockito.any(Chofer::class.java))).thenReturn(choferMock)
        val response= choferService.update(choferMock)
        Assertions.assertEquals(response.id,choferMock.id)
        Assertions.assertEquals(response.chofers,choferMock.chofers)


    }
    @Test
    fun UpdateChoferIfPassedList(){
        val response: Boolean=choferService.UpdateChoferIfPassedList( "Pedro")
        Assertions.assertEquals(false,response)


    }
    @Test
    fun UpdateChoferIfNotPassedList(){
        val response: Boolean=choferService.UpdateChoferIfPassedList( "marquiño")
        Assertions.assertEquals(true,response)

    }



}