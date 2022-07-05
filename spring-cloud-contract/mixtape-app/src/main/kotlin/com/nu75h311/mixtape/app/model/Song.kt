package com.nu75h311.mixtape.app.model

import java.util.*

data class Song(
    val id: UUID,
    val name: String,
    val artist: String,
    val duration: String // This app cares about the duration attribute
)