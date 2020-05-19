package sam.kotlin

import sam.java.Created
import sam.java.User

fun main(args: Array<String>) {
    var user = User("Pi")
    var count = 0

    //Kotlin lambdas can be sent to Java 8 as parameters
    //Here the same object/lambda we passed is being reused
    user.create {println("User $it has been created")}
    user.create {println("User $it has been created")}

    //Here we are capturing the state of count, in this case, every time we call create
    //a new lambda object is being created and passed
    user.create {println("User $it has been created ${++count} times")}
    user.create {println("User $it has been created ${++count} times")}

    //The following code does not compile because Kotlin doesn't now what 'it' is, it can't infer its type.
    //val eventListener = {println("User $it has been created ${++count} times")}
    //If we want to declare the lambda once and use it later in different places, Kotlin provide a SAM constructor
    //In this case the constructor is for the Created interface
    val eventListener = Created {println("User $it has been created ${++count} times")}

    user.create(eventListener)
    user.create(eventListener)

    //I guess we can also declare the types like so
    val eventListener2 = {u:User -> println("User $u has been created ${++count} times")}
    user.create(eventListener2)
    user.create(eventListener2)
}