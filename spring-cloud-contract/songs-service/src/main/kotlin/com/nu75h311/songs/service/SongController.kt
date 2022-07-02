package com.nu75h311.songs.service

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("songs")
class SongController(val service: SongService) {

    @GetMapping()
    fun getSongs(@RequestParam artist: String?): List<Song> {
        return if (artist == null) service.findSongs()
        else service.findSongsByArtist(artist) //add this as an exercise
    }

    @PostMapping
    fun post(@RequestBody song: Song) {
        service.saveSong(song)
    }
}