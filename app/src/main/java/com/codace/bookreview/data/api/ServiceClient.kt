package com.codace.bookreview.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceClient {

    companion object {

        private var BASE_URL = "https://www.googleapis.com/books/v1/"

        fun create(): IBooksApiService {

            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient())
                .build()

            return retrofit.create(IBooksApiService::class.java)
        }

        private fun httpClient(): OkHttpClient {

            val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
                .addInterceptor(object: Interceptor {

                    override fun intercept(chain: Interceptor.Chain): Response {
                        val request: Request = chain
                            .request()
                            .newBuilder()
                            .addHeader("key", "AIzaSyDmF9H4FyBfma0ESfjtaYGjEcPW7KuiT3k")
                            .build()

                        return chain.proceed(request)
                    }

                })

            return okHttpClientBuilder.build()

        }

    }

}