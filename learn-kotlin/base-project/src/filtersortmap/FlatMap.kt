package filtersortmap

fun main(args: Array<String>) {
    val meetings = listOf(Meeting(1, "Travel Japan"), Meeting(1, "About Dallas Job"))

    //Making the type explicit to show that this is list of lists
    val people: List<List<Person>> = meetings.map { m -> m.people }

    //I can use flatMap to avoid that problem
    val flat: List<Person> = meetings
        .flatMap { m -> m.people }
        .distinct()

    for (p: Person in flat) println(p.name)
}

data class Meeting(val id: Int, val title: String) {
    val people = listOf(Person("Alex"), Person("Chio"))
}

data class Person(val name: String) {}