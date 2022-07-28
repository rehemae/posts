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
    var body: String
)

//fun <T>compareIds(item1: T, item2:T):T{
//    var output=(item1.toString() + item2.toString())
//    println(output)
//    return item2
//    }
//fun stage(){
//    var post1=Post(1,"rehema",8,"She likes eating")
//    var post2=Post(3,"ray",6,"She likes coding")
//    compareIds(post1,post2)
//
//    var comment1=Comment(2,3,"rehemaa","rehemaa@gmail.com","she likes playing")
//    var comment2=Comment(2,3,"Ephraim","ephraim@gmail.com","He like reading books")
//    compareIds(comment1,comment2)
//}



