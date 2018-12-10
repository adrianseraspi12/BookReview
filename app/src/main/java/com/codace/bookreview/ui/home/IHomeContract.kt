package com.codace.bookreview.ui.home

import com.codace.bookreview.data.Model

interface IHomeContract {

    interface View {

        fun setPresenter(presenter: Presenter)

        fun showNewReleaseBooks(listOfNewReleaseBooks: MutableList<Model.ItemBook>)

        fun showRelevantBooks(listOfRelevantBooks: MutableList<Model.ItemBook>)

    }

    interface Presenter {

        fun loadNewReleaseBooks(startIndex: Int, itemsPerPage: Int)

        fun loadRelevantBooks(startIndex: Int, itemsPerPage: Int)

    }

}