package com.example.android_studio_retrofit_starwars_api.model

data class DadesAPI(
    val count: Int,
    val next: String,
    val previous: Any,
    val characters: List<CharacterStarwars>
)