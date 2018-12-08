package com.codace.bookreview.ui.home.relevant

import com.codace.bookreview.data.Model

interface IRelevantContract {

    interface View {

        fun setPresenter(presenter: Presenter)

        fun setUpAdapter(listOfRelevantBooks: MutableList<Model.ItemBook>)

    }

    interface Presenter {

        fun loadRelevantBooks(startIndex: Int, itemsPerPage: Int)

    }

}