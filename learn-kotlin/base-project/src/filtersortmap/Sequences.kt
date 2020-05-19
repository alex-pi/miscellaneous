package filtersortmap

fun main(args: Array<String>) {
    val meetings = listOf(Meeting(1, "Travel Japan"),
        Meeting(2, "About Dallas Job"),
        Meeting(3, "About Japan Onsen"))

    //When used as a sequence every element is passed through the whole "stream", one after the other. (Lazy evaluation)
    //Whereas normally, the whole list would be filtered, generating another list and then mapped which generates
    //yet another list, this can become a memory problem with large lists/collections.
    //Is in this cases where we use sequences.
    val titles = meetings.asSequence()
        .filter {
            println("filter($it)")
            it.title.contains("Japan")
        }.map {
            println("map($it)")
            it.title
        }

    //The sequence is not executed until it is used
    println(titles.toList())

    //Here the sequence stops as soon as find is true, we say find is a terminal operation
    //this is very efficient because all the steps in the sequence are executed only until the
    //terminal method/operation returns true.
    val title = meetings.asSequence()
        .map {
            println("map($it)")
            it.title.toUpperCase()
        }
        .find { it.contains("JAPAN") }

    println(title)
}