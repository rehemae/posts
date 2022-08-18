package dev.rehema.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.rehema.myposts.databinding.ActivityCommentctivityBinding


class CommentRvAdapter(var currentList: List<Comment>): RecyclerView.Adapter<commentViewHolder>() {
    override fun onBindViewHolder(holder: commentViewHolder, position: Int) {
        var currentComment = currentList.get(position)

        holder.bindingView.tvposttittle.text = currentComment.tittle
        holder.bindingView.tvpostbody.text = currentComment.body
        val context = holder.itemView.context
//        holder.bindingView.cvComment.setOnClickListener {
//            val intent = Intent(holder.itemView.context, Commentctivity::class.java)
//            intent.putExtra("COMMENT_ID", currentComment.id)
//            context.startActivity(intent)
//
//        }

        with(holder.bindingView){
            tvposttittle.text=currentComment.body
            tvpostbody.text=currentComment.tittle
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): commentViewHolder {
        var binding =ActivityCommentctivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return commentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}
class commentViewHolder(var bindingView:ActivityCommentctivityBinding):
    RecyclerView.ViewHolder(bindingView.root){

}





