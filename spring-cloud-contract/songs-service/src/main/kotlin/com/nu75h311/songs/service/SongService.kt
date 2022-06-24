package com.nu75h311.songs.service

import org.springframework.stereotype.Service

@Service
class SongService(val db: SongRepository) {

    fun findSongs(): MutableIterable<Song> = db.findAll()

    fun findSongsByArtist(artist: String): MutableIterable<Song> = db.findAllByArtist(artist)

    fun saveSong(song: Song) {
        db.save(song)
    }
}