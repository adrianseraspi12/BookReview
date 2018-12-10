package com.codace.bookreview.ui.home

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codace.bookreview.R
import com.codace.bookreview.data.Model
import com.codace.bookreview.utils.ext.inflate
import com.codace.bookreview.utils.ext.load
import kotlinx.android.synthetic.main.row_horizontal_item_book.view.*

class BooksAdapter(private val list:List<Model.ItemBook>):
        RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.row_horizontal_item_book, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemBook = list[position]
        holder.bind(itemBook)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(book: Model.ItemBook) {
            itemView.item_title.text = book.volumeInfo.title
            itemView.item_rating.text = book.volumeInfo.averageRating.toString()
            itemView.item_thumbnail.load(book.volumeInfo.imageLinks.smallThumbnail) {
                it.centerCrop()
                it.fit()
            }

        }

    }

}