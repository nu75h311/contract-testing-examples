package com.nu75h311.songs.service.contracts

import au.com.dius.pact.provider.junit5.PactVerificationContext
import au.com.dius.pact.provider.junitsupport.Provider
import au.com.dius.pact.provider.junitsupport.State
import au.com.dius.pact.provider.junitsupport.loader.PactBroker
import au.com.dius.pact.provider.spring.junit5.PactVerificationSpringProvider
import com.nu75h311.songs.service.Song
import com.nu75h311.songs.service.SongRepository
import org.junit.jupiter.api.TestTemplate
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import java.util.*

@Provider("SongsService")
@PactBroker
//@PactFolder("pacts") // If pacts are stored somewhere locally
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("contract-test")
class SongsServiceContractTests {

    @MockBean
    lateinit var songRepositoryMock: SongRepository

    @TestTemplate
    @ExtendWith(PactVerificationSpringProvider::class)
    fun verifyPact(context: PactVerificationContext) {
        context.verifyInteraction()
    }

    @State("songs exist")
    fun toSongsExistState() {
        Mockito.`when`(songRepositoryMock.findAll()).thenReturn(
            mutableListOf(
                Song(UUID.randomUUID(), "Xanadu", "Rush", 664)
            )
        )
    }
}