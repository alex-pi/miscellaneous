package hlfuns

import java.math.BigInteger

fun main(args: Array<String>) {
    val p = Program()

    //This is what we normally do with an Strategy pattern Using classic OO
    p.fibonacci(n = 10, p = object : Process {
        override fun execute(value: BigInteger) {
            print("$value, ")
        }
    })

    println()
    //Now passing a lambda function looks like this
    //The lambda can be passed out or inside the ()
    p.fibonacci(10) {v -> print("$v, ")}
    println()
    p.fibonacci(10) {print("$it, ")}
    println()
    //I can even passed a function reference
    p.fibonacci(n = 4, action = ::println)

    //Even in Java 8 we can't mutate variables in the closure/scope (although there're ways to get around that rule).
    //Java 8 would force us to declare "total" as final, so it won't be able to mutate
    //Kotlin generates a bytecode that allows us to mutate variables/objects, in this case, total is being
    //changed from inside the lambda
    println()
    var total : BigInteger = BigInteger.ZERO
    p.fibonacci(4) {total = total.plus(it)}
    println(total)
}

interface Process {
    fun execute(value: BigInteger)
}

class Program {

    tailrec fun fibonacci(n: Int, a: BigInteger = BigInteger.ONE, b: BigInteger = BigInteger.ZERO, p: Process): BigInteger {
        p.execute(a)
        return if(n == 0) b else fibonacci(n - 1, a + b, a, p)
    }

    tailrec fun fibonacci(n: Int, a: BigInteger = BigInteger.ONE, b: BigInteger = BigInteger.ZERO, action: (BigInteger) -> Unit): BigInteger {
        action(a)
        return if(n == 0) b else fibonacci(n - 1, a + b, a, action)
    }
}