package com.codace.bookreview.data.repository

import com.codace.bookreview.data.api.IBooksApiService
import com.codace.bookreview.data.Model
import com.codace.bookreview.data.api.ServiceClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.github.ajalt.timberkt.Timber

class DataRepositoryImpl : IDataRepository {

    private var booksApiService: IBooksApiService = ServiceClient.create()

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
                            Timber.i { "DataRepository = Successful" }
                        }
                        else {
                            Timber.i{"DataRepository = Not Successful" +
                                    "\n Response code = ${response.code()}" }
                        }

                    }

                    override fun onFailure(call: Call<Model.ListBook>,
                                           t: Throwable) {
                        Timber.i{"DataRepository = ${t.message}"}

                    }

                })
    }

}