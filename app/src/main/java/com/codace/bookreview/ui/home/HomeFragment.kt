package com.codace.bookreview.ui.home


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.codace.bookreview.R
import com.codace.bookreview.data.Model
import com.codace.bookreview.ui.home.newrelease.NewReleaseActivity

import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), IHomeContract.View {

    private lateinit var presenter: IHomeContract.Presenter

    companion object {

        fun newInstance(): HomeFragment = HomeFragment()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        home_new_release_button.setOnClickListener {
            startActivity(Intent(context, NewReleaseActivity::class.java))
        }

    }

    override fun onStart() {
        super.onStart()
        presenter.loadNewReleaseBooks(0, 5)
        presenter.loadRelevantBooks(0, 5)
    }

    override fun setPresenter(presenter: IHomeContract.Presenter) {
        this.presenter = presenter
    }

    override fun showNewReleaseBooks(listOfNewReleaseBooks: MutableList<Model.ItemBook>) {
        home_new_release_list.adapter = BooksAdapter(listOfNewReleaseBooks)
    }

    override fun showRelevantBooks(listOfRelevantBooks: MutableList<Model.ItemBook>) {
        home_relevant_list.adapter = BooksAdapter(listOfRelevantBooks)
    }

}
