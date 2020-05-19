package highorder.kotlin

import java.lang.RuntimeException

fun main(args: Array<String>) {
    val action = { println("Hello World") }
    val product = {x: Int, y: Int -> x*y}

    doSomething(action)

    val numbers = listOf(1,2,3,4,3,5)

    val theFirst = first(numbers) {n -> n == 3 }
    println(theFirst)
}

fun doSomething(func: () -> Unit) {
    func()
}

//For this function, Kotlin will generate a separate class with a single method to be called.
//That can be very expensive in the number of classes that can get created
//We can ask Kotlin to generate the code inline, basically means to insert it where the function is referenced.
//We can use inline if the function will be called immediately. If for instance we store it in a variable to be called
//later on, then inline should not be used
inline fun <T> first(items: List<T>, predicate: (T) -> Boolean) : T {
    for (item in items) {
        if (predicate(item)) return item
    }
    throw RuntimeException()
}