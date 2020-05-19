package simple

import java.util.*

fun main(args:Array<String>) {

    //close or inclusive range
    for (i in 1..5){
        print("$i,")
    }
    println()
    //set an increment or step
    for (i in 1..10 step 2){
        print("$i,")
    }
    println()
    //decrementing range
    for (i in 5 downTo 1) {
        print("$i,")
    }
    println()
    //until excludes the last value
    for (i in 1 until 5) {
        print("$i,")
    }
    println()
    for (i in listOf(4,7,2,8,8,4)) {
        print("$i,")
    }
    println()
    val ages = TreeMap<String, Int>()
    ages["Pi"] = 37
    ages["Chio"] = 37
    ages["Mona"] = 32

    for ((name, age) in ages) {
        println("$name is $age")
    }

    //As long as a type implements Comparable, it can create a range
    println()
    for (c in 'a'..'z') {
        print("$c,")
    }

    //If we need the index...
    println()
    val numbers = 1..10 step 2
    for((i, num) in numbers.withIndex()) {
        println("$i - $num")
    }

    //A String implements Comparable, so it can be managed as a range
    println()
    for(c in "Hello") {
        print("$c, ")
    }
}