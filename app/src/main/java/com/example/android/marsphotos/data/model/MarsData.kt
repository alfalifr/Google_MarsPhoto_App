package com.example.android.marsphotos.data.model

import com.squareup.moshi.Json

data class MarsData(
  val id: Int,
  @Json(name = "img_src")
  val imgSrc: String
)
