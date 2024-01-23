package com.example.animelist.data.repository

import com.example.animelist.data.Anime
import com.example.animelist.data.AnimeData

class AnimeRepository {
    fun getAnime(): List<Anime> {
        return AnimeData.anime
    }
    fun searchAnime(query: String): List<Anime>{
        return AnimeData.anime.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
    companion object {
        @Volatile
        private var instance: AnimeRepository? = null

        fun getInstance(): AnimeRepository =
            instance ?: synchronized(this) {
                AnimeRepository().apply {
                    instance = this
                }
            }
    }
}