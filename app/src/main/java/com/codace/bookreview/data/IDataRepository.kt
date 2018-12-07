package com.codace.bookreview.data

interface IDataRepository {

    interface Listener<T> {

        fun onDataAvailable(data: T)

        fun onDataNotAvailable(message: String)

    }

    fun getListOfBooks(query: String, orderBy: String,
                       startIndex: Int, itemsPerPage: Int,
                       listener: Listener<Model.ListBook?>)

}