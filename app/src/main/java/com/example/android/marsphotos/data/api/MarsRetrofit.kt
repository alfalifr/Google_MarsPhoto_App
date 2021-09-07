package com.example.android.marsphotos.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object MarsRetrofit {
  const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

  val retrofit: Retrofit by lazy {
    Retrofit.Builder()
      .addConverterFactory(
        MoshiConverterFactory.create(
          Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        )
      )
      .baseUrl("$BASE_URL/")
      .build()
  }

  val api: MarsApi by lazy {
    retrofit.create(MarsApi::class.java)
  }
}