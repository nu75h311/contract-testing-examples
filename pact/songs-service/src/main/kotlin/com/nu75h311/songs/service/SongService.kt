package com.nu75h311.songs.service

import org.springframework.stereotype.Service

@Service
class SongService(val db: SongRepository) {

    fun findSongs(): List<SongDTO> = db.findAll().map { convertToSongDTO(it) }

    fun findSongsByArtist(artist: String): List<SongDTO> = db.findAllByArtist(artist).map { convertToSongDTO(it) }

    fun saveSong(songDto: SongDTO) {
        db.save(convertToSong(songDto))
    }
}