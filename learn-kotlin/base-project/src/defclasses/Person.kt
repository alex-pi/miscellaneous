package defclasses


fun main(args: Array<String>) {
    val kevin = Student("Kevin","Jones",1)
    println(kevin.id)
    println(kevin.getName())
    println(kevin.tutor?.getName())

    val tutor1 = Tutor("Alex", "Pi", 1)
    val monin = Student("La", "Monin", 2, tutor1)

    println(monin.tutor?.getName())

    //id can't be change since is defined as value (val)
    //kevin.id = 2
}

//classes and methods are final by default, we need to be explicit when we want the class to be extended
//actually, even in java is a good practice to have classes as final unless you are providing an extension point
//we can also use abstract, same rules apply as in Java.

//Some differences from Java:
//Everything is public by default
//No stupid 'package-private' scoping
//Kotlin has 'internal' keyword, internal elements are only visible within the same 'compilation unit'
//a single maven project would an example of compilation unit.
abstract class Person(var firstName: String, var lastName: String) {

    open fun getName() : String = "$firstName $lastName"
    abstract fun getAddress(): String
}

//notice the () after Person, that means we are calling the default constructor
class Student(firstName: String, lastName: String, val id: Int) : Person(firstName, lastName) {
    //tutor can change so we use var.
    //we could also have used a init {} method
    var tutor: Tutor? = null

    //Note that using default arguments I can get rid of the secondary constructor, just need to declare the
    //default constructor as:
    // Student(firstName: String, lastName: String, val id: Int, var tutor: Tutor? = null)
    constructor(firstName: String, lastName: String, id: Int, tutor: Tutor): this(firstName, lastName, id) {
        this.tutor = tutor
    }

    override fun getName() : String {return "Student: ${super.getName()}"}

    override fun getAddress(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class Tutor(firstName: String, lastName: String, _id: Int) : Person(firstName, lastName) {
    val id: Int

    //init method is another way of initializing the val attributes. val need to be initialized before
    //the instance is created.
    init {
        id = _id
    }

    override fun getName() : String {return "Tutor: ${super.getName()}"}

    override fun getAddress(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}