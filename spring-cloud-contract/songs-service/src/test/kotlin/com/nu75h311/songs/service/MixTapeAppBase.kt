package com.nu75h311.songs.service

import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.junit.jupiter.api.BeforeEach
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class MixTapeAppBase {

    @Mock
    lateinit var songRepositoryMock: SongRepository

    @BeforeEach
    fun setup() {

        Mockito.`when`(songRepositoryMock.findAll()).thenReturn(
            mutableListOf(
                Song(UUID.randomUUID(), "Xanadu", "Rush", 664),
                Song(UUID.randomUUID(), "Lithium", "Nirvana", 257)
            )
        )

        Mockito.`when`(songRepositoryMock.findAllByArtist(anyString())).thenReturn(
            mutableListOf(
                Song(UUID.randomUUID(), "Xanadu", "Rush", 664),
                Song(UUID.randomUUID(), "XXY", "Rush", 265)
            )
        )

        RestAssuredMockMvc.standaloneSetup(SongController(SongService(songRepositoryMock)))
    }
}