package com.revia.musicapp.api

import com.revia.musicapp.responseData.MyData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIInterface {

    @Headers("X-RapidAPI-Key: 1c047ae58emshfa560c3dac8ea3bp18499ajsne9360e0d1274" + "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q") query: String) : Call<MyData>
}