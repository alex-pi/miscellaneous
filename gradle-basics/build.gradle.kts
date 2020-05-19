tasks.register("upper") {
    doLast {
        val someString = "AleJanDro"
        println("Original: $someString")
        println("Upper case: ${someString.toUpperCase()}")
    }
}