package com.codace.bookreview.ui.home.newrelease

import com.codace.bookreview.data.Model

interface INewReleaseContract {

    interface View {

        fun setPresenter(presenter: Presenter)

        fun updateList(listOfNewReleaseBooks: MutableList<Model.ItemBook>)

    }

    interface Presenter {

        fun loadNewReleaseBooks(startIndex: Int, itemsPerPage: Int)

    }

}