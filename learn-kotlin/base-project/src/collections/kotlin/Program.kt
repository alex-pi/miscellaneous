package collections.kotlin

import collections.java.Organizer

fun main(args: Array<String>) {
    //Varios things happen here:
    //1) Kotlin infers the type of the list elements as List<Climber?> (list od Nullable Climbers
    //2) The val crew itself is not nullable
    //3) The list is by default immutable
    val crew = listOf(Climber("pi"), Climber("Chio"), Climber("Ondra"), null)

    for (c in crew) println(c)
    println()
    for (c in crew.filterNotNull()) print("$c , ")
    println()

    //This list does't have a add method as it is immutable
    //crew.add()

    //Let's be explicit with the types
    //crewToTheRed is Nullable, but the list can't hold nulls
    val crewToTheRed: MutableList<Climber>? = mutableListOf<Climber>(Climber("Mike"), Climber("Ileana"))

    //we can't add nulls
    //crewToTheRed?.add(null)

    crewToTheRed?.add(Climber("Jessica"))
    //Seems like I cant use a nullable val to get an iterator with the classic for
    //for (c: Climber? in crewToTheRed?.iterator()) println(c)
    crewToTheRed?.forEach { print("$it , ") }
}

data class Climber(val name: String): Organizer {

    //When implementing the Java interface we need to decide wht kind of List this will be.
    //Mutable or not, Nullable or not...
    override fun assignRoutes(routes: MutableList<String>?) {
        println("Do something here")
    }

}