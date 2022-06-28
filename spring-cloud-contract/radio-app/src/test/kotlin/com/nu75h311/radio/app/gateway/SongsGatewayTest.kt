package com.nu75h311.radio.app.gateway

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties

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

        val songList = songsGateway.getSongs()

        org.junit.jupiter.api.assertAll("songs",
            { assertEquals(1, songList.size) }
        )
    }
}