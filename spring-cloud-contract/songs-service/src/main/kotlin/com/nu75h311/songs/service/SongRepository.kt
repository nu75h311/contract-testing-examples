package com.nu75h311.songs.service

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SongRepository : CrudRepository<Song, String> {

    fun findAllByArtist(artist: String): MutableIterable<Song>
}