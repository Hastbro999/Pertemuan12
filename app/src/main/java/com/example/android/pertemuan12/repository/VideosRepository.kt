package com.example.android.pertemuan12.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.pertemuan12.database.VideosDatabase
import com.example.android.pertemuan12.database.asDomainModel
import com.example.android.pertemuan12.domain.DevByteVideo
import com.example.android.pertemuan12.network.DevByteNetwork
import com.example.android.pertemuan12.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class VideosRepository(private val database: VideosDatabase) {

    val videos: LiveData<List<DevByteVideo>> = Transformations.map(database.videoDao.getVideos()) {
        it.asDomainModel()
    }
    // refresh video untuk mengambil data dari internet
    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            Timber.d("refresh videos is called");
            val playlist = DevByteNetwork.devbytes.getPlaylist()
            database.videoDao.insertAll(playlist.asDatabaseModel())
        }
    }

}
