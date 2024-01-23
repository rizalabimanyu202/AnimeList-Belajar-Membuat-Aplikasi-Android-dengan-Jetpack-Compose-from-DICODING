package com.example.animelist.dl

import com.example.animelist.data.repository.AnimeRepository

object Injection {
    fun provideRepository(): AnimeRepository {
        return AnimeRepository.getInstance()
    }
}