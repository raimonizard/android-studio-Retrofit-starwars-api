package com.example.retrofitapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
        // Mentre carrega les dades de la API Rest, ens mostra un disc de progrés
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
            /*
            item(){
                // TEST: Per comprovar què hem recuperat de la API REST
                Text(text="$characters")
            }*/

            for (i in 0..characters.results.size - 1){
                item(){
                    CharacterItem(characters.results.get(i))
                }
            }
        }
    }
}
