package dev.rehema.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.rehema.myposts.databinding.ActivityViewPostBinding


class PostRvAdapter(var postList: List<Post>): RecyclerView.Adapter<RetrofitViewHolder>() {
    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentpost = postList.get(position)
//        with(holder.bindingView) {
//             tvId.text= currentpost.id.toString()
//            tvUserId.text = currentpost.userId.toString()
//            tvTitle.text = currentpost.tittle
//            val context=holder.itemView.context
//            tvbody.text = currentpost.body
//            var intent = Intent(holder.itemView.context,Commentctivity::class.java)
//            intent.putExtra("Post_id",currentpost.id)
//            context.startActivity(intent)
//        }
        holder.bindingView.tvTitle.text = currentpost.tittle
        holder.bindingView.tvbody.text = currentpost.body
        val context = holder.itemView.context
        holder.bindingView.rcPosts.setOnClickListener {
            val intent = Intent(holder.itemView.context, Commentctivity::class.java)
            intent.putExtra("POST_ID", currentpost.id)
            context.startActivity(intent)

        }


//       with(holder.bindingView) override fun getItemCount(): Int {
        with(holder.bindingView){
            tvbody.text=currentpost.body
          tvTitle.text=currentpost.tittle
        }
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
            var binding =
                ActivityViewPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return RetrofitViewHolder(binding)
        }

    override fun getItemCount(): Int {
        return postList.size
    }
}

class RetrofitViewHolder(var bindingView: ActivityViewPostBinding):
        RecyclerView.ViewHolder(bindingView.root) {

        }





