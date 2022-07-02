package com.nu75h311.radio.app.gateway

import com.nu75h311.radio.app.model.Song
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties
import java.util.*

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(
    ids = ["com.nu75h311:songs-service:+:stubs:6565"],
    stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
internal class SongsGatewayTest {

    @Autowired
    lateinit var songsGateway: SongsGateway

    @Test
    fun getSongs() {

        val sliver = Song(
            UUID.fromString("37808461-ca2c-47ee-849f-7367170efd25"), "Sliver", "Nirvana"
        )
        val songList = songsGateway.getSongs()

        org.junit.jupiter.api.assertAll("songs",
            {
                assertThat(songList.size).isEqualTo(2)
                assertThat(songList).contains(sliver)
            }
        )
    }
}