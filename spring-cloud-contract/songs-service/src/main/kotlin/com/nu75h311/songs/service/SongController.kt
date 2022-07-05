package com.nu75h311.songs.service

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("songs")
class SongController(val service: SongService) {

    @GetMapping()
    fun getSongs(@RequestParam artist: String?): List<SongDTO> {
        return if (artist == null) service.findSongs()
        else service.findSongsByArtist(artist)
    }

    @PostMapping
    fun post(@RequestBody song: SongDTO) {
        service.saveSong(song)
    }
}