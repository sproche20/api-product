package com.paul.primera.api.service

import com.google.gson.Gson
import com.paul.primera.api.Model.Chofer
import com.paul.primera.api.Model.Rutas

import com.paul.primera.api.repository.RutasRepository
import com.paul.primera.api.services.RutasService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class rutasServiceTest {
    @InjectMocks
    lateinit var  rutasService: RutasService
    @Mock
    lateinit var rutasRepository: RutasRepository
    val jsonString = File("./src/test/resources/rutas.json").readText(Charsets.UTF_8)
    val rutasMock = Gson().fromJson(jsonString, Rutas::class.java)
    @Test
    fun createRuta(){
        Mockito.`when`(rutasRepository.save(Mockito.any(Rutas::class.java))).thenReturn(rutasMock)
        val response = rutasService.save(rutasMock)
        Assertions.assertEquals(response.id, rutasMock.id)
        Assertions.assertEquals(response.ruta, rutasMock.ruta)

    }
    @Test
    fun createRutaFailedWhenNameIsEntry(){
        Assertions.assertThrows(Exception::class.java) {
            rutasMock.apply { ruta="    "}
            Mockito.`when`(rutasRepository.save(Mockito.any(Rutas::class.java))).thenReturn(rutasMock)
            rutasService.save(rutasMock)
        }
    }
    @Test
    fun updateIsCorrect(){
        Mockito.`when`(rutasRepository.findById(rutasMock.id)).thenReturn(rutasMock)
        Mockito.`when`(rutasRepository.save(Mockito.any(Rutas::class.java))).thenReturn(rutasMock)
        val response=rutasService.update(rutasMock)
        Assertions.assertEquals(response.id,rutasMock.id)
        Assertions.assertEquals(response.ruta,rutasMock.ruta)



    }
    @Test
    fun updateIsNotExistedFailed(){
        Assertions.assertThrows(Exception::class.java){
            Mockito.`when`(rutasRepository.findById(rutasMock.id)).thenReturn(null)
            Mockito.`when`(rutasRepository.save(Mockito.any(Rutas::class.java))).thenReturn(rutasMock)
            rutasService.update(rutasMock)
        }

    }
    @Test
    fun updateIsFailedWhenDescriptionIsNull(){
        rutasMock.apply {
            ruta=" "
        }
        Mockito.`when`(rutasRepository.findById(rutasMock.id)).thenReturn(rutasMock)
        Mockito.`when`(rutasRepository.save(Mockito.any(Rutas::class.java))).thenReturn(rutasMock)
        val response= rutasService.update(rutasMock)
        Assertions.assertEquals(response.id,rutasMock.id)
        Assertions.assertEquals(response.ruta,rutasMock.ruta)


    }

}