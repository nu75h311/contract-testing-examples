package com.nu75h311.songs.service

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("SONGS")
data class Song(@Id val id: UUID?, val name: String, val artist: String)
