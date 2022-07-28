package dev.rehema.myposts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.rehema.myposts.databinding.ActivityMainBinding.inflate
import dev.rehema.myposts.databinding.ActivityViewPostBinding
import dev.rehema.myposts.databinding.ActivityViewPostBinding.bind
import dev.rehema.myposts.databinding.ActivityViewPostBinding.inflate



class PostRvAdapter(var context: Context, var postList: List<Post>): RecyclerView.Adapter<RetrofitViewHolder>() {


    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentItem = postList.get(position)
        with(holder.bindingView) {
             tvId.text= currentItem.id.toString()
            tvUserId.text = currentItem.userId.toString()
            tvTitle.text = currentItem.tittle
            tvbody.text = currentItem.body
        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding = ActivityViewPostBinding.inflate(LayoutInflater.from(context), parent, false)
        return RetrofitViewHolder(binding)
    }
}

class RetrofitViewHolder(var bindingView: ActivityViewPostBinding) :
    RecyclerView.ViewHolder(bindingView.root) {

}




