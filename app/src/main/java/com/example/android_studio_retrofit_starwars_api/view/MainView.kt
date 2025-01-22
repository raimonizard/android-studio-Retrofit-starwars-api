package com.example.retrofitapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.android_studio_retrofit_starwars_api.model.DadesAPI
import com.example.retrofitapp.viewmodel.APIViewModel

@Composable
fun MainView(myAPIViewModel: APIViewModel) {
    val showLoading: Boolean by myAPIViewModel.loading.observeAsState(true)
    val characters: DadesAPI by myAPIViewModel.characters.observeAsState(DadesAPI(0, "", 0, emptyList()))

    myAPIViewModel.getCharacters()

    if (showLoading) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.secondary
            )
        }
    } else {
        LazyColumn {
            for (i in 0..characters.characters.size){
                item(){
                    CharacterItem(characters.characters.get(i))
                }
            }

            /*
            items(characters.characters) {
                character -> CharacterItem(character = character)
            }
            */
        }
    }
}
