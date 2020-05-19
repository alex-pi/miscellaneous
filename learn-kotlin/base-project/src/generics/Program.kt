package generics

fun main(args: Array<String>) {
    val names = listOf("Pi", "Chio")
    val ages = listOf(37, 36)

    println(names.itemAt(0))

    ages.apply {
        println(itemAt(0))
    }

    println(Node(3).value())
}

fun <T> List<T>.itemAt(idx: Int): T {
    return this[idx]
}

class Node<T>(private val value: T) {
    fun value(): T {
        return value
    }
}

fun printType(items: List<Any>) {
    //Generic types are erased by the compiler, so at runtime, we can do checks like the one below.
    //This gives a compiled error.
    //if(items is List<String>)
    print("We have Strings")

    //we could do something like below, but that is an unchecked cast that might explode at runtime
    val stuff = items as List<String>
}
