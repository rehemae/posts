package dev.rehema.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.rehema.myposts.databinding.ActivityCommentctivityBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Commentctivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentctivityBinding
    var postId = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityCommentctivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPost()
        fetchComment()


    }

    fun obtainPostId() {
        postId = intent.extras?.getInt("POST_ID") ?: 0

    }

    fun fetchPost() {
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostById(postId)
        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                var post = response.body()
                if (post != null) {
                    binding.tvposttittle.text = post.tittle
                    binding.tvpostbody.text = post.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {

            }
        }
        )
    }

    fun fetchComment() {
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getcommentId(postId)
        request.enqueue(object : Callback<List<comment>> {
            override fun onResponse(call: Call<List<comment>>, response: Response<List<comment>>) {
                if (response.isSuccessful) {
                    var comments = response.body()
                    if (comments != null)
                        displaycomment(comments)

                }
            }

            override fun onFailure(call: Call<List<comment>>, t: Throwable) {
                Toast.makeText(baseContext,t.message, Toast.LENGTH_LONG).show()


            }

        })
    }

    fun displaycomment(commentList: List<comment>) {
        binding.rvcommentlist.layoutManager = LinearLayoutManager(this)
        var commentRvAdapter = CommentRvAdapter(commentList)
        binding.rvcommentlist.adapter = commentRvAdapter
    }
//        request.enqueue(object:Callback<List<Comment>>{
//            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
//
//                var comment = response.body()
//                if (comment != null) {
////                  tvposttittle.text=comment.tittle
////                      .tvpostbody.text=comment.body
//////                    binding.tvposttittle.text=comment.email
//                }
//            }
//            override fun onFailure(call: Call<comment>, t: Throwable) {
//            }
//        })

}




//private fun Any.enqueue(callback: Callback<comment>) {
//
//}
