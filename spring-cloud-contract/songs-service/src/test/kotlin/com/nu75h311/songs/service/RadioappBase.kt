package com.nu75h311.songs.service

import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class RadioappBase {

    @Mock
    lateinit var songRepositoryMock: SongRepository

    @BeforeEach
    fun setup() {

        Mockito.`when`(songRepositoryMock.findAll()).thenReturn(
            listOf(
                Song(UUID.randomUUID(), "Xanadu", "Rush"),
                Song(UUID.randomUUID(), "Some", "Other")
            )
        )

        RestAssuredMockMvc.standaloneSetup(SongController(SongService(songRepositoryMock)))
    }
}