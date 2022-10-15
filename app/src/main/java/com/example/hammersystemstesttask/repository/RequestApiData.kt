package com.example.hammersystemstesttask.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RequestApiData {

    @GET("episode/1")
    fun getRequestEpisode(
//            @Path("id") id: String
    ): Call<Episode>

    @GET("character/{ids}")
    fun getRequestListCharacter(@Path("ids") ids: String): Call<List<CharacterItem>>
}