package com.example.android.marsphotos

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android.marsphotos.data.model.MarsData
import com.example.android.marsphotos.overview.MarsPhotoAdapter

@BindingAdapter("imgUrl")
fun bindImage(iv: ImageView, url: String?) {
  if(url != null) {
    val uri = url.toUri()
      .buildUpon()
      .scheme("https")
      .build()
    iv.load(uri) {
      placeholder(R.drawable.loading_animation)
      error(R.drawable.ic_connection_error)
    }
  }
}

@BindingAdapter("dataList")
fun bindRvAdapter(rv: RecyclerView, dataList: List<MarsData>?) {
  (rv.adapter as MarsPhotoAdapter).submitList(dataList)
}

@BindingAdapter("loadingVisibility")
fun bindAdpLoading(pb: ProgressBar, dataList: List<MarsData>?) {
  pb.visibility = if(dataList == null) View.VISIBLE
  else View.GONE
}