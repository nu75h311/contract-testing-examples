package com.nu75h311.radio.app.gateway

import com.nu75h311.radio.app.model.Song
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.RequestEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@Component
class SongsGateway(
    val restTemplate: RestTemplate,
    @Value("\${songs.service.baseUrl}") val songsServiceBaseUrl: String
) {

    fun getSongs(): List<Song> {
        val url: URI = UriComponentsBuilder
            .fromHttpUrl(songsServiceBaseUrl).path("songs")
//            .queryParam("artist", artist)
            .encode().build().toUri()

        val songsServiceResponse = restTemplate.exchange(
            RequestEntity<Any>(HttpMethod.GET, url),
            object : ParameterizedTypeReference<List<Song>>() {}
        )

        return songsServiceResponse.body!!
    }

}
