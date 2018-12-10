package com.codace.bookreview.ui.home.relevant


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.codace.bookreview.R
import com.codace.bookreview.data.Model
import com.codace.bookreview.ui.home.BooksAdapter

import kotlinx.android.synthetic.main.fragment_home_relevant.*

class RelevantFragment : Fragment(), IRelevantContract.View {

    private lateinit var presenter: IRelevantContract.Presenter

    companion object {

        fun newInstance(): RelevantFragment = RelevantFragment()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home_relevant, container, false)
    }

    override fun onStart() {
        super.onStart()
        presenter.loadRelevantBooks(0, 5)
    }

    override fun setPresenter(presenter: IRelevantContract.Presenter) {
        this.presenter = presenter
    }

    override fun setUpAdapter(listOfRelevantBooks: MutableList<Model.ItemBook>) {
        relevant_list.adapter = BooksAdapter(listOfRelevantBooks)
    }

}
