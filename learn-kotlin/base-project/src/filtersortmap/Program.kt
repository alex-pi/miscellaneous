package filtersortmap

fun main(args: Array<String>) {
    val ints = listOf(1, 2, 3, 4, 5, 6)

    val smallInts = ints.filter { it < 4 }
    for (i: Int in smallInts) print("$i, ")

    println()
    val squared = ints
        .filter { it < 3 }
        .map { it * it }
    for (i: Int in squared) print("$i, ")
}