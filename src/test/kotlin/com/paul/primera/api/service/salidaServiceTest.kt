package com.paul.primera.api.service

import com.google.gson.Gson
import com.paul.primera.api.Model.Buses
import com.paul.primera.api.Model.Chofer
import com.paul.primera.api.Model.Rutas
import com.paul.primera.api.Model.Salid
import com.paul.primera.api.repository.BusesRepository
import com.paul.primera.api.repository.RutasRepository
import com.paul.primera.api.repository.SalidRepository
import com.paul.primera.api.services.BusesService
import com.paul.primera.api.services.SalidService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class salidaServiceTest {
    @InjectMocks
    lateinit var salidService: SalidService

    @Mock
    lateinit var busesRepository: BusesRepository
    @Mock
    lateinit var salidRepository: SalidRepository
    @Mock
    lateinit var rutasRepository: RutasRepository

    val jsonString = File("./src/test/resources/buses.json").readText(Charsets.UTF_8)
    val busMock = Gson().fromJson(jsonString, Buses::class.java)

    val jsonString1 = File("./src/test/resources/salida.json").readText(Charsets.UTF_8)
    val salidaMock = Gson().fromJson(jsonString, Salid::class.java)

    val jsonString2 = File("./src/test/resources/rutas.json").readText(Charsets.UTF_8)
    val rutasMock = Gson().fromJson(jsonString, Rutas::class.java)

    @Test
    fun createSalida(){
        Mockito.`when`(busesRepository.findById(salidaMock.bus__id)).thenReturn(busMock)

        Mockito.`when`(rutasRepository.findById(salidaMock.ruta__id)).thenReturn(rutasMock)

        Mockito.`when`(salidRepository.save(Mockito.any(Salid::class.java))).thenReturn(salidaMock)
        val response = salidService.save(salidaMock)
        Assertions.assertEquals(response.id, salidaMock.id)
        Assertions.assertEquals(response.salid, salidaMock.salid)
        Assertions.assertEquals(response.horasal, salidaMock.horasal)
    }
}