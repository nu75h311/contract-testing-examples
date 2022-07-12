package com.nu75h311.songs.service.contracts

import com.nu75h311.songs.service.Song
import com.nu75h311.songs.service.SongController
import com.nu75h311.songs.service.SongRepository
import com.nu75h311.songs.service.SongService
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.junit.jupiter.api.BeforeEach
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
                Song(UUID.randomUUID(), "Xanadu", "Rush", 664)
            )
        )

        RestAssuredMockMvc.standaloneSetup(SongController(SongService(songRepositoryMock)))
    }
}