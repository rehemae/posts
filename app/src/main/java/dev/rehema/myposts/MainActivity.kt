package dev.rehema.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.rehema.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPosts()
    }

    fun getPosts(){
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = retrofit.getPosts()
        request.enqueue(object : retrofit2.Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful){
                    var posts = response.body()
                    if (posts != null)
                        displayPosts(posts)
//                    Toast.makeText(baseContext, "fetched${posts!!.size} posts", Toast.
//                    LENGTH_LONG).show()
//                    var adapter=PostRvAdapter(baseContext,posts)
//                    binding.Rvposts.layoutManager = LinearLayoutManager(baseContext)
//                    binding.Rvposts.adapter=adapter

                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

            }

        })
        }
    fun displayPosts(postsList:List<Post>){
        binding.Rvposts.layoutManager=LinearLayoutManager(this)
        var PostsAdapter=PostRvAdapter(postsList)
        binding.Rvposts.adapter=PostsAdapter
    }


}