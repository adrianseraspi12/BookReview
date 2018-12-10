package com.codace.bookreview.ui.home

import com.codace.bookreview.data.Model
import com.codace.bookreview.data.repository.IDataRepository

class HomePresenter(
    private val dataRepository: IDataRepository,
    private val mView: IHomeContract.View
) : IHomeContract.Presenter {

    init {
        mView.setPresenter(this)
    }

    override fun loadNewReleaseBooks(startIndex: Int, itemsPerPage: Int) {
        dataRepository.getListOfBooks(
            "\"\"",
            "newest",
            startIndex, itemsPerPage,
            object : IDataRepository.Listener<Model.ListBook?> {

                override fun onDataAvailable(data: Model.ListBook?) {
                    data?.let {
                        mView.showNewReleaseBooks(it.items.toMutableList())
                    }
                }

                override fun onDataNotAvailable(message: String) {

                }

            })
    }

    override fun loadRelevantBooks(startIndex: Int, itemsPerPage: Int) {
        dataRepository.getListOfBooks(
            "\"\"",
            "relevance",
            startIndex, itemsPerPage,
            object : IDataRepository.Listener<Model.ListBook?> {

                override fun onDataAvailable(data: Model.ListBook?) {
                    data?.let {
                        mView.showRelevantBooks(it.items.toMutableList())
                    }
                }

                override fun onDataNotAvailable(message: String) {

                }

            }

        )
    }

}