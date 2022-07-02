package com.nu75h311.radio.app.integration

import com.nu75h311.radio.app.service.SongsService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(
    ids = ["com.nu75h311:songs-service:+:stubs:6565"],
    stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
internal class SongsServiceTest {

    @Autowired
    lateinit var service: SongsService

    @Test
    fun getSongNameListByArtist() {

        val songList = service.getListOfSongNames()

        assertAll("song names",
            { assertThat(songList).containsExactlyInAnyOrder("Sliver", "Xanadu") }
        )
    }
}