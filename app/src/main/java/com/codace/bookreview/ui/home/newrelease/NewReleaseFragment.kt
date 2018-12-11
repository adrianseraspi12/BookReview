package com.codace.bookreview.ui.home.newrelease

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.codace.bookreview.R
import com.codace.bookreview.data.Model
import com.codace.bookreview.ui.home.BooksAdapter
import kotlinx.android.synthetic.main.fragment_book_vertical_list.*

class NewReleaseFragment : Fragment(), INewReleaseContract.View {

    private lateinit var presenter: INewReleaseContract.Presenter

    companion object {

        fun newInstance(): NewReleaseFragment = NewReleaseFragment()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_book_vertical_list, container, false)
    }

    override fun onStart() {
        super.onStart()
        presenter.loadNewReleaseBooks(0, 10)
    }

    override fun setPresenter(presenter: INewReleaseContract.Presenter) {
        this.presenter = presenter
    }

    override fun updateList(listOfNewReleaseBooks: MutableList<Model.ItemBook>) {
        book_list.adapter = BooksAdapter(listOfNewReleaseBooks)
    }
}