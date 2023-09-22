package com.learn.submiissionfundamentalbyoby.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.learn.submiissionfundamentalbyoby.data.response.ItemsItem
import com.learn.submiissionfundamentalbyoby.data.response.UserResponse
import com.learn.submiissionfundamentalbyoby.databinding.ItemUserBinding

class userAdapter : ListAdapter<ItemsItem, userAdapter.MyViewHolder>(DIFF_CALLBACK){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    class MyViewHolder(val binding : ItemUserBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(resource: ItemsItem){
            binding.apply {
                tvUser.text = "${resource.login}\n- ${resource.id}"
                Glide.with(itemView)
                    .load(resource.avatarUrl)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .into(imgUser)
            }
        }
    }

    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ItemsItem>(){

            override fun areItemsTheSame(oldItem: ItemsItem, newItem: ItemsItem) : Boolean{
                return oldItem == newItem
            }
            override fun areContentsTheSame(oldItem: ItemsItem, newItem : ItemsItem) : Boolean{
                return oldItem == newItem
            }

        }
    }
}