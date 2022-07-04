package com.nu75h311.radio.app.service

import com.nu75h311.radio.app.gateway.SongsGateway
import com.nu75h311.radio.app.model.Song
import org.springframework.stereotype.Service

@Service
class SongsService(val songsGateway: SongsGateway) {

    fun getListOfSongNames(): List<String> {
        val songsResponse = songsGateway.getSongs()

        return songsResponse.map { song: Song -> song.name }
    }

    fun getListOfSongNamesByArtist(artist: String): List<String> {
        val songsResponse = songsGateway.getSongsByArtist(artist)

        return songsResponse.map { song: Song -> song.name }
    }

}