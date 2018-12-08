package com.codace.bookreview.ui.home.relevant

import com.codace.bookreview.data.Model
import com.codace.bookreview.data.repository.IDataRepository

class RelevantPresenter(
    val dataRepo: IDataRepository,
    val mView: IRelevantContract.View):
        IRelevantContract.Presenter, IDataRepository.Listener<Model.ListBook?> {

    init {
        mView.setPresenter(this)
    }

    override fun loadRelevantBooks(startIndex: Int, itemsPerPage: Int) {
        dataRepo.getListOfBooks(
            "\"\"", "relevance",
            startIndex, itemsPerPage, this)
    }

    override fun onDataAvailable(data: Model.ListBook?) {
        if (data != null) {
            mView.setUpAdapter(data.items.toMutableList())
        }
    }

    override fun onDataNotAvailable(message: String) {

    }

}