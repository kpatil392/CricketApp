package com.cricket.test.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cricket.test.databinding.ItemPostViewBinding
import com.example.roomwithretrofit.Model.Post


class PostAdapter(val context: Context, var list: List<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    class PostViewHolder(private val binnding: ItemPostViewBinding) :
        RecyclerView.ViewHolder(binnding.root) {
        fun bind(post: Post) {
         binnding.tvPlayerName.text=post.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(
            ItemPostViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

}