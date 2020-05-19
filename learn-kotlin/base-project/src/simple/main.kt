package simple

fun main(args: Array<String>) {
    println("Some basic concepts")

    // type is inferred
    var q =  Question()
    // we can also be explicit
    var q2:Question = Question()

    q.Answer = "42"
    //this marks an error since question is immutable
    //q.question = ""

    //Here it just prints the toString of the q instance, the rest is just a String
    println("The answer is $q.Answer")

    //String interpolation needs curly braces in this case
    println("The answer to the question: ${q.Question} is ${q.Answer}")

    //In Kotlin if is an expression that evaluates to a result.
    //This way "message" can be immutable, which is good.
    //Note that == works as a "equals". In Java we don't use == to compared 2 Strings.
    val message = if(q.Answer == q.CorrectAnswer) {
        "You were correct!"
    } else {
        "Wrong! Try Again?"
    }

    println(message)

    /////////////

    //val makes it immutable
    //By default, in Kotlin, nothing can be null unless we say it explicitly
    //This gives an error
    //val q3:Question = null
    //The ? tells Kotlin q3 can be null
    val q3:Question? = null
    //we can't reassign
    //q3 = Question()

    //If we use q3 we must use either the ? or !! operators
    //? tells Kotlin to evaluate only if q3 is not null
    q3?.Answer = "44"
    //with !! we tell Kotlin: I know what I'm doing, this is not null
    //In this case the line below will terminate the program with NullPointerException (since q3 is null)
    //q3!!.Answer = "45"
    println("The answer is ${q3?.Answer}")

    q.printResult()

    //try can also be an expression
    val number:Int? = try {
        Integer.parseInt(q.Answer)
    } catch (e:NumberFormatException) {
        //If parse fails null is assigned to number
        null
    }

    println("Your answer as Int is $number")
}

class Question {
    var Answer:String = ""
    val CorrectAnswer:String = "42"
    val Question = "What is the answer to life, the universe and everything?"

    fun display() {
        println("You said $Answer")
    }

    fun printResult() {
        //There is no switch but a much more elegant when statement.
        when(Answer) {
            CorrectAnswer -> println("You were correct!")
            else -> println("Wrong! Try Again?")
        }
    }
}