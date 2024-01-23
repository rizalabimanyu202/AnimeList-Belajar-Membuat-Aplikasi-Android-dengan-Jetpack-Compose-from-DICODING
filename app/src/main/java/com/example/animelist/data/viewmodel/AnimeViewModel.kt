package com.example.animelist.data.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.animelist.data.repository.AnimeRepository
import com.example.animelist.data.Anime
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AnimeViewModel(private val animeRepository: AnimeRepository): ViewModel() {
    private val _groupedAnime = MutableStateFlow(
        animeRepository.getAnime()
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    )
    val groupedAnime: StateFlow<Map<Char, List<Anime>>> get() = _groupedAnime
    private val _query = mutableStateOf("")
    val query: State<String> get() = _query
    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedAnime.value = animeRepository.searchAnime(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }
}

class ViewModelFactory(private val animeRepository: AnimeRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnimeViewModel::class.java)) {
            return AnimeViewModel(animeRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}