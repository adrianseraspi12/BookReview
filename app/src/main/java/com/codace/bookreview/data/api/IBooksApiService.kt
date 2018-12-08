package com.codace.bookreview.data.api

import com.codace.bookreview.data.Model
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface IBooksApiService {

    @GET("volumes")
    fun getListOfBooks(
            @Query("q") query: String,
            @Query("orderBy") orderBy: String,
            @Query("startIndex") startIndex: Int,
            @Query("maxResults") itemsPerPage: Int):
            Call<Model.ListBook>

}