package com.codace.bookreview.ui.home.relevant

import com.codace.bookreview.data.Model

interface IRelevantContract {

    interface View {

        fun setPresenter(presenter: Presenter)

        fun setUpAdapter(listOfRelevantBooks: List<Model.VolumeInfo>)

    }

    interface Presenter {

        fun loadRelevantBooks(itemsPerPage: Int)

    }

}