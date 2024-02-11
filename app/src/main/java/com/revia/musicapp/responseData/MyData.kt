package com.revia.musicapp.responseData

data class MyData(
    val `data`: List<Data>,
    val next: String,
    val total: Int
)