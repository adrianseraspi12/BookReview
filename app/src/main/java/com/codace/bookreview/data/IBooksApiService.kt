package com.codace.bookreview.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface IBooksApiService {

    companion object {

        fun create(): IBooksApiService {

            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://www.googleapis.com/books/v1")
                    .build()

            return retrofit.create(IBooksApiService::class.java)

        }

    }

    @GET("/volumes")
    fun getListOfBooks(
            @Query("q") query: String,
            @Query("orderBy") orderBy: String,
            @Query("startIndex") startIndex: Int,
            @Query("maxResults") itemsPerPage: Int):
            Call<Model.ListBook>

}