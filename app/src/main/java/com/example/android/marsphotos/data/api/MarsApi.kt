package com.example.android.marsphotos.data.api

import com.example.android.marsphotos.data.model.MarsData
import retrofit2.http.GET

interface MarsApi {
  @GET("photos")
  suspend fun getPhotos(): List<MarsData>
}