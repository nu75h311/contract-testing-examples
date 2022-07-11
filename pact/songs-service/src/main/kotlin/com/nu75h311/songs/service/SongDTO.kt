package com.nu75h311.songs.service

import java.util.*

data class SongDTO(
    val id: UUID?,
    val name: String,
    val artist: String,
    val duration: String
)

fun convertToSong(songDTO: SongDTO): Song {
    return Song(null, songDTO.name, songDTO.artist, convertToIntDuration(songDTO.duration))
}

fun convertToSongDTO(song: Song): SongDTO {
    return SongDTO(song.id, song.name, song.artist, convertToStringDuration(song.duration))
}

private fun convertToStringDuration(durationInt: Int): String {
    val hours: Int = durationInt / 3600
    val minutes: Int = durationInt / 60
    val seconds: String = (durationInt % 60).toString().padStart(2, '0')
    if (hours == 0) {
        return "${minutes}:${seconds}"
    }
    return "${hours}:${minutes}:${seconds}"
}

private fun convertToIntDuration(durationString: String): Int {
    val splitDuration = durationString.split(':')
    if (splitDuration.size == 2) {
        return splitDuration[0].toInt() * 60 + splitDuration[1].toInt()
    }
    return splitDuration[0].toInt() * 3600 + splitDuration[1].toInt() * 60 + splitDuration[2].toInt()
}