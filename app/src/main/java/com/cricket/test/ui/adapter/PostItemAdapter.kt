package com.cricket.test.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cricket.test.databinding.ItemPostViewBinding
import com.example.roomwithretrofit.Model.Post

class PostItemAdapter(val context: Context, var list: List<Post>) :
    RecyclerView.Adapter<PostItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(binding: ItemPostViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemPostViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostItemAdapter.ItemViewHolder, position: Int) {
        holder.bind(list.get(position))
    }
}