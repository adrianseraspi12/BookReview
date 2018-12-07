package com.codace.bookreview.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepositoryImpl : IDataRepository {

    private var booksApiService: IBooksApiService = IBooksApiService.create()

    override fun getListOfBooks(query: String, orderBy: String, startIndex: Int, itemsPerPage: Int,
                                listener: IDataRepository.Listener<Model.ListBook?>) {
        booksApiService.getListOfBooks(
                query,
                orderBy,
                startIndex,
                itemsPerPage)
                .enqueue(object: Callback<Model.ListBook> {

                    override fun onResponse(call: Call<Model.ListBook>,
                                            response: Response<Model.ListBook>) {

                        if (response.isSuccessful) {
                            listener.onDataAvailable(response.body())
                        }

                    }

                    override fun onFailure(call: Call<Model.ListBook>,
                                           t: Throwable) {

                    }

                })
    }

}