package com.nu75h311.songs.service

import org.springframework.stereotype.Service

@Service
class SongService(val db: SongRepository) {

    fun findSongs(): List<Song> = db.findAll().toList()

    fun findSongsByArtist(artist: String): List<Song> = db.findAllByArtist(artist).toList()

    fun saveSong(song: Song) {
        db.save(song)
    }
}