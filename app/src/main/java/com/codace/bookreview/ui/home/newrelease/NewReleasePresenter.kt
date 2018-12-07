package com.codace.bookreview.ui.home.newrelease

import com.codace.bookreview.data.IDataRepository
import com.codace.bookreview.data.Model

class NewReleasePresenter: INewReleaseContract.Presenter,
        IDataRepository.Listener<Model.ListBook?> {

    private var dataRepo: IDataRepository
    private var mView: INewReleaseContract.View

    constructor(dataRepo: IDataRepository,
                mView: INewReleaseContract.View) {
        this.dataRepo = dataRepo
        this.mView = mView

        mView.setPresenter(this)
    }

    override fun loadNewReleaseBooks(startIndex: Int, itemsPerPage: Int) {
        dataRepo.getListOfBooks("", "newest", startIndex, itemsPerPage, this)
    }

    override fun onDataAvailable(data: Model.ListBook?) {
        if (data != null) {
            mView.updateList(data.items)
        }
    }

    override fun onDataNotAvailable(message: String) {

    }

}