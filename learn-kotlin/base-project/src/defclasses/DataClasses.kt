package defclasses

fun main(args: Array<String>) {
    var kevin = Student2(1, "Kevin")
    var jones = Student2(1, "Kevin")

    println(kevin)

    //this would normally just compare the object references, but Student2 is a "data class"
    //so Kotlin uses equals under the covers.
    if(kevin == jones) {
        println("Equal")
    } else {
        println("Not Equal")
    }

    var robert = kevin.copy(name = "Robert")

    println(robert)
}

//by declaring Student2 as a "data class", Kotling provides various things:
// 1) equals method using all the constructor parameters
// 2) hasCode method
// 3) toString method
// 4) copy method
data class Student2(val id: Int, val name: String) {

}