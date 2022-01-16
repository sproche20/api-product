package com.paul.primera.api

import com.paul.primera.api.services.ChoferService
import io.jsonwebtoken.lang.Assert
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

@SpringBootTest
class PrimeraApiApplicationTests {
	@Autowired
	lateinit var choferService: ChoferService

	@Test
	fun contextLoads() {
	}
	@Test
	fun verifycedulalengthisIncorrect(){
		val response: Boolean=choferService.verifycedulalength( "123")
		Assertions.assertEquals(false,response)

	}
	@Test
	fun verifycedulalengthisCorrect(){
		val response: Boolean=choferService.verifycedulalength( "1234567890")
		Assertions.assertEquals(true,response)

	}


}
