package com.example.android.marsphotos.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.data.model.MarsData
import com.example.android.marsphotos.databinding.GridViewItemBinding

class MarsPhotoAdapter
  : ListAdapter<MarsData, MarsPhotoAdapter.ViewHolder>(
  DiffCallback
) {

  inner class ViewHolder(val binding: GridViewItemBinding)
    : RecyclerView.ViewHolder(binding.root)

  companion object DiffCallback: DiffUtil.ItemCallback<MarsData>() {
    override fun areItemsTheSame(
      oldItem: MarsData,
      newItem: MarsData
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
      oldItem: MarsData,
      newItem: MarsData
    ): Boolean = oldItem.imgSrc == newItem.imgSrc
  }

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ViewHolder {
    val binding = GridViewItemBinding.inflate(
      LayoutInflater.from(parent.context)
    )
    return ViewHolder(binding)
  }

  override fun onBindViewHolder(
    holder: ViewHolder,
    position: Int
  ) {
    holder.binding.data = getItem(position)!!
  }
}