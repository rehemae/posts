package dev.rehema.myposts

class Item(){
    var id: Int=0
}

data class Post(
    var userId:Int,
    var tittle:String,
    var id: Int,
    var body: String)


data class Comment(
    var postId:Int,
    var id: Int,
    var name:String,
    var email:String,
    var body: String,
    var tittle: String,
)





