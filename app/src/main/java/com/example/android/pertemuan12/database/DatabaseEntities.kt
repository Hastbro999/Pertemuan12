package com.example.android.pertemuan12.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.pertemuan12.domain.DevByteVideo

@Entity
// untuk membuat tabel di database
data class DatabaseVideo constructor(
    @PrimaryKey
    val url: String,
    val updated: String,
    val title: String,
    val description: String,
    val thumbnail: String
)

// untuk mengubah tabel menjadi domain
fun List<DatabaseVideo>.asDomainModel(): List<DevByteVideo> {
    return map {
        DevByteVideo(
            url = it.url,
            title = it.title,
            description = it.description,
            updated = it.updated,
            thumbnail = it.thumbnail
        )
    }
}
