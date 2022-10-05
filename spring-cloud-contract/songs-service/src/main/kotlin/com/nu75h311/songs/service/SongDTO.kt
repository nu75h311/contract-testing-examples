package com.nu75h311.songs.service

import java.util.*

data class SongDTO(
    val id: UUID?,
    val name: String,
    val artist: String
)

fun convertToSong(songDTO: SongDTO): Song {
    return Song(null, songDTO.name, songDTO.artist)
}

fun convertToSongDTO(song: Song): SongDTO {
    return SongDTO(song.id, song.name, song.artist)
}
