package com.codace.bookreview.ui.home.newrelease


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.codace.bookreview.R
import com.codace.bookreview.data.Model
import com.codace.bookreview.ui.home.BooksAdapter
import kotlinx.android.synthetic.main.fragment_new_release.*

class NewReleaseFragment : Fragment(), INewReleaseContract.View {

    private lateinit var presenter: INewReleaseContract.Presenter

    private val listOfBooks: MutableList<Model.VolumeInfo> = ArrayList()

    private val adapter: BooksAdapter = BooksAdapter(listOfBooks)

    companion object {

        val newInstance: NewReleaseFragment = NewReleaseFragment()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_new_release, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        new_release_list.layoutManager = LinearLayoutManager(context)
        new_release_list.hasFixedSize()
        new_release_list.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        presenter.loadNewReleaseBooks(0, 5)
    }

    override fun setPresenter(presenter: INewReleaseContract.Presenter) {
        this.presenter = presenter
    }

    override fun updateList(listOfNewReleaseBooks: MutableList<Model.VolumeInfo>) {
        listOfBooks.addAll(listOfNewReleaseBooks)
        adapter.notifyDataSetChanged()
    }

}
