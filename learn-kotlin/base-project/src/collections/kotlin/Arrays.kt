package collections.kotlin

fun main(args: Array<String>) {

    for (i in args.indices) {
        println("args[$i] = ${args[i]}")
    }

    val numbers = intArrayOf(1,3,4,5,8,5)

    numbers.forEachIndexed { i, e ->
        print("numbers[$i] = $e, ")
    }
    println()

    val chars = CharArray(2)
    chars[0] = 'a'
    chars[1] = 'b'

    chars.forEachIndexed { i, c ->  print("chars[$i] = $c, ")}
}