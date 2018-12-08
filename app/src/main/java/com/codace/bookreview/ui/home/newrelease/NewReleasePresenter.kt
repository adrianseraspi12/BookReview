package com.codace.bookreview.ui.home.newrelease

import com.codace.bookreview.data.Model
import com.codace.bookreview.data.repository.IDataRepository
import com.github.ajalt.timberkt.Timber

class NewReleasePresenter(
    private var dataRepo: IDataRepository,
    private var mView: INewReleaseContract.View):
    INewReleaseContract.Presenter, IDataRepository.Listener<Model.ListBook?> {

    init {
        mView.setPresenter(this)
    }

    override fun loadNewReleaseBooks(startIndex: Int, itemsPerPage: Int) {
        dataRepo.getListOfBooks("\"\"", "newest", startIndex, itemsPerPage, this)
    }

    override fun onDataAvailable(data: Model.ListBook?) {
        if (data != null) {
            for (itemBook: Model.ItemBook in data.items) {
                Timber.i{"ID = ${itemBook.id}"}
            }
            mView.updateList(data.items.toMutableList())
        }
    }

    override fun onDataNotAvailable(message: String) {
        Timber.i{"Presenter = $message"}
    }

}