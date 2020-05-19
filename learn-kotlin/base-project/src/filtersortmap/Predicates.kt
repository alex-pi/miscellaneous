package filtersortmap

fun main(args: Array<String>) {
    val ints = listOf(1,2,3,4,5,6)
    //If we defined a predicate without applying it, Kotlin can't infer the type
    //We need to specify the types
    val greaterThanThree = { i:Int -> i > 3 }

    println(ints.all { it > 3 })
    println(ints.any { it > 3 })
    println(ints.count(greaterThanThree))
    println(ints.find(greaterThanThree))

    //find returns null if not found
    var found: Int? = ints.find { it > 6 }
    //Why is not forcing me to use the ?
    println(found.toString())
}