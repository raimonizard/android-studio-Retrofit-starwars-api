package com.example.android_studio_retrofit_starwars_api.api

class Repository {
    val apiInterface = com.example.retrofitapp.api.APIInterface.Companion.create()
    suspend fun getAllCharacters() = apiInterface.getCharacters()
}