package com.paul.primera.api.service

import com.google.gson.Gson
import com.paul.primera.api.Model.Buses
import com.paul.primera.api.Model.Chofer
import com.paul.primera.api.repository.BusesRepository
import com.paul.primera.api.repository.ChoferRepository
import com.paul.primera.api.services.BusesService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class BusesServiceTest {
    @InjectMocks
    lateinit var busesService: BusesService

    @Mock
    lateinit var busesRepository: BusesRepository
    @Mock
    lateinit var choferRepository: ChoferRepository


    val jsonString = File("./src/test/resources/buses.json").readText(Charsets.UTF_8)
    val busMock = Gson().fromJson(jsonString, Buses::class.java)

    val jsonString1 = File("./src/test/resources/chofer.json").readText(Charsets.UTF_8)
    val choferMock = Gson().fromJson(jsonString1, Chofer::class.java)

    @Test
    fun createBus(){
        Mockito.`when`(choferRepository.findById(busMock.id__chofer)).thenReturn(choferMock)

        Mockito.`when`(busesRepository.save(Mockito.any(Buses::class.java))).thenReturn(busMock)
        val response = busesService.save(busMock)
        Assertions.assertEquals(response.id, busMock.id)
        Assertions.assertEquals(response.marcas, busMock.marcas)
        Assertions.assertEquals(response.placas, busMock.placas)
    }
    @Test
    fun createChoferFailedWhenNameIsEntry(){
        Assertions.assertThrows(Exception::class.java) {
            busMock.apply { marcas="    "}
            Mockito.`when`(busesRepository.save(Mockito.any(Buses::class.java))).thenReturn(busMock)
            busesService.save(busMock)
        }
    }
    @Test
    fun updateIsCorrect(){
        Mockito.`when`(choferRepository.findById(busMock.id__chofer)).thenReturn(choferMock)

        Mockito.`when`(busesRepository.findById(busMock.id)).thenReturn(busMock)
        Mockito.`when`(busesRepository.save(Mockito.any(Buses::class.java))).thenReturn(busMock)
        val response=busesService.update(busMock)
        Assertions.assertEquals(response.id,busMock.id)
        Assertions.assertEquals(response.marcas,busMock.marcas)
        Assertions.assertEquals(response.placas, busMock.placas)



    }
    @Test
    fun updateIsNotExistedFailed(){
        Assertions.assertThrows(Exception::class.java){
            Mockito.`when`(busesRepository.findById(busMock.id)).thenReturn(null)
            Mockito.`when`(busesRepository.save(Mockito.any(Buses::class.java))).thenReturn(busMock)
            busesService.update(busMock)
        }

    }
    @Test
    fun updateIsFailedWhenDescriptionIsNull(){
        busMock.apply {
            marcas=" "
        }

        Mockito.`when`(choferRepository.findById(busMock.id__chofer)).thenReturn(choferMock)
        Mockito.`when`(busesRepository.findById(busMock.id)).thenReturn(busMock)
        Mockito.`when`(busesRepository.save(Mockito.any(Buses::class.java))).thenReturn(busMock)
        val response= busesService.update(busMock)
        Assertions.assertEquals(response.id,busMock.id)
        Assertions.assertEquals(response.marcas,busMock.marcas)


    }

}
