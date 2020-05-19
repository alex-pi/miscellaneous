@file:JvmName("MyUtils")

package funs

import java.math.BigInteger

fun main(args: Array<String>) {
    println("max(6,5) = ${max(6,5)}")

    //Can't mix named and positional parameters, order does not matter
    log(level = 2, message = "Hoa!")
    //default parameters still work
    log(message = "Hoah!")

    val text = "This    contained   multiple \t spaces"
    //We call the extension function like this
    println(text.replaceSpaces())

    val h1 = Header("h1")
    val h2 = Header("h2")

    //Notice we don't use h1.plus(h2)
    println((h1 plus  h2).Name)

    //Using operator overloading
    println((h1 + h2).Name)

    //Without tail recursion, this will cause a stack overflow
    println(fib(100000, BigInteger("1"), BigInteger("0")))

    //The compiler doesn't give an error, but factorialA is not a tail recursive function
    //println(factorialA(BigInteger("10000")))
    println(factorialA(BigInteger("4")))

    //factorialB is rewritten in tailrec mode
    println(factorialB(BigInteger("52")))

    println(factorialC(BigInteger("52")))
}

//Function expressions
fun max(a: Int, b :Int) : Int = if(a>b) a else b

//Default Parameters
@JvmOverloads
fun log(message: String, level: Int = 1) {
    println("$message -> $level")
}

//Extension functions are added to a particular class
//Note that we do not pass the String parameter, instead "this" is the receiver,
//in other words, the instance that calls the method.
//Instead of having the classic StringUtils we add extension functions to the Class itself.
fun String.replaceSpaces() : String {
    val regex = Regex("\\s+")
    return regex.replace(this, " ")
}

class Header(var Name: String) {}

//infix mean that we can use the function plus as an operator
//even further, we can add operator to do a "operator overloading" like we used to in C++
//seems like when we use "operator" the function must be named in a standard way
infix operator fun Header.plus(other: Header): Header {
    return Header(this.Name + other.Name)
}

//tailrec indicates Kotlin that is safe to internally convert this in a loop
//kotlin optimizes this. a recursive function must follow certain rules so that it
//can be optimized as a loop
tailrec fun fib(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    return if(n == 0) b else fib(n - 1, a + b, a)
}

//The recursive call IS NOT the last operation performed in the function, hence, it can't be optimized
tailrec fun factorialA(n: BigInteger): BigInteger {
    return if(n == BigInteger.ONE) n else n * factorialA(n - BigInteger.ONE)
}

//this uses an internal function that is tail recursive
fun factorialB(n: BigInteger): BigInteger {

    tailrec fun f(acc: BigInteger = BigInteger.ONE, c: BigInteger): BigInteger {
        return if(c > n) acc else f(acc * c , c + BigInteger.ONE)
    }

    return f(c = BigInteger.ONE)
}

tailrec fun factorialC(n: BigInteger, acc: BigInteger = BigInteger.ONE): BigInteger {
    return if(n == BigInteger.ZERO) acc else factorialC(n - BigInteger.ONE, acc * n)
}