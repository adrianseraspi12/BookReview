package com.codace.bookreview.data

object Model {

    data class ListBook(val totalItems: Int, val items: List<ItemBook>)

    data class ItemBook(val id: String, val volumeInfo: VolumeInfo)

    data class VolumeInfo(val title: String, val subtitle: String,
                          val publisher: String, val publishedDate:
                          String, val description: String, val averageRating: Float,
                          val ratingsCount: Int, val authors: List<String>)

}