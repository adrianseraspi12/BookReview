package com.codace.bookreview.ui.home.newrelease


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.codace.bookreview.R
import com.codace.bookreview.data.Model
import com.codace.bookreview.ui.home.BooksAdapter
import com.github.ajalt.timberkt.Timber
import kotlinx.android.synthetic.main.fragment_new_release.*

class NewReleaseFragment : Fragment(), INewReleaseContract.View {

    private lateinit var presenter: INewReleaseContract.Presenter

    companion object {

        fun newInstance(): NewReleaseFragment = NewReleaseFragment()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_new_release, container, false)
    }

    override fun onStart() {
        super.onStart()
        presenter.loadNewReleaseBooks(0, 5)
    }

    override fun setPresenter(presenter: INewReleaseContract.Presenter) {
        this.presenter = presenter
    }

    override fun updateList(listOfNewReleaseBooks: MutableList<Model.ItemBook>) {
        new_release_list.adapter = BooksAdapter(listOfNewReleaseBooks)
    }
}