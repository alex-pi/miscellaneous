package simple

fun main(args: Array<String>) {

    val person1 = Person("Alex")

    person1.sayName()

    person1.greetings(::sayHi)
}

fun sayHi(s: String) {
    println("Hi $s!!")
}