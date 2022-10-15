package com.example.hammersystemstesttask.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hammersystemstesttask.viewmodel.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {

    private val retrofit = Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    private val requestApiGithubRepos = retrofit.create(RequestApiData::class.java)

    private var multipleCharacter: String? = null
    private val _characters = MutableLiveData<List<CharacterItem>>()
    val characters: LiveData<List<CharacterItem>> = _characters

    fun startLoad() {
        loadEpisodeData()
    }

    private fun loadEpisodeData() {
        Log.d(TAG, "Repository: loadEpisodeData")

        val call = requestApiGithubRepos.getRequestEpisode()

        call.enqueue(object : Callback<Episode> {
            override fun onFailure(call: Call<Episode>, t: Throwable) {
                Log.d(TAG, "Repository: onFailure")
            }

            override fun onResponse(call: Call<Episode>, response: Response<Episode>) {
                Log.d(TAG, "isSuccessful ${response.isSuccessful}")
                Log.d(TAG, "response.body() ${response.body()}")

                loadListCharacters(response.body())

            }
        })
    }

    private fun compositionCharacterRequest(episode: Episode?) {
        val listIDs = episode?.characters?.map { it.substringAfterLast('/') }
        multipleCharacter = listIDs?.joinToString()
        Log.d(TAG, "compositionCharacterRequest:  $multipleCharacter")

    }

    private fun loadListCharacters(episode: Episode?) {
        Log.d(TAG, "Repository: loadListCharacters")
        if (!episode?.characters.isNullOrEmpty())
            compositionCharacterRequest(episode)

        val call = requestApiGithubRepos.getRequestListCharacter(ids = multipleCharacter!!)

        call.enqueue(object : Callback<List<CharacterItem>> {
            override fun onFailure(call: Call<List<CharacterItem>>, t: Throwable) {}

            override fun onResponse(call: Call<List<CharacterItem>>,
                    response: Response<List<CharacterItem>>) {
                if (response.isSuccessful) _characters.value = response.body()
            }
        })
    }

}