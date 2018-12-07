package com.codace.bookreview.data

object Model {

    data class SingleBook(val volumeInfo: VolumeInfo)

    data class ListBook(val totalItems: Int, val items: MutableList<VolumeInfo>)

    data class VolumeInfo(val title: String, val subtitle: String,
                          val publisher: String, val publishedDate:
                          String, val description: String, val averageRating: Float,
                          val ratingsCount: Int, val authors: Authors)

    data class Authors(val authors: List<String>)

}