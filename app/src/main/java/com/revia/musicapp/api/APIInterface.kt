package com.revia.musicapp.api

import com.revia.musicapp.responseData.MyData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIInterface {

    @GET("search")
    fun getData(@Query("q") query: String) : Call<MyData>
}