package com.example.android.pertemuan12.domain

import com.example.android.pertemuan12.util.smartTruncate

data class DevByteVideo(
    val title: String,
    val description: String,
    val url: String,
    val updated: String,
    val thumbnail: String
) {

    val shortDescription: String
        get() = description.smartTruncate(200)
}