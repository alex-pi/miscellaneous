package text

fun main(args: Array<String>): Unit {
    val original = "a/bb[1]/ab[11]"

    val new = original.replaceRange(original.lastIndexOf('[')..original.lastIndex
        , "[id=1]")

    println(new)
}