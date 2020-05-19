package objects

//Kotlin actually creates a class with a companion object that contains the main method.
//that is why the IDE refers the class with the main method like: objects.PersonKt
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

    //In this case we use a companion object to create factory
    val pipo = Student.createPostGrad("Pipo")
}

class Program {
    companion object {

        //To have the JVM detect the main method, we have to annotate it
        @JvmStatic
        fun main(args: Array<String>) {
            val s1 = Student.createUnderGrad("Monin")
            println(s1.firstName)
        }
    }
}

abstract class Person(var firstName: String, var lastName: String) {

    open fun getName() : String = "$firstName $lastName"
    abstract fun getAddress(): String
}

open class Student(firstName: String, lastName: String, val id: Int) : Person(firstName, lastName) {
    var tutor: Tutor? = null

    constructor(firstName: String, lastName: String, id: Int, tutor: Tutor): this(firstName, lastName, id) {
        this.tutor = tutor
    }

    override fun getName() : String {return "Student: ${super.getName()}"}

    override fun getAddress(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun enrole(courseName: String) {
        val course = Courses.allCourses
            .filter { it.title == courseName }
            .firstOrNull()
    }

    //There are no static members in Kotlin, instead, we can use companion object like so.
    //objects can implement interfaces if needed
    companion object : XmlSerializer<Student>{

        override fun toXml(item: Student) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        fun createUnderGrad(name: String): Undergraduate {
            return Undergraduate(name)
        }
        fun createPostGrad(name: String): Postgraduate {
            return Postgraduate(name)
        }
    }
}

class Tutor(firstName: String, lastName: String, _id: Int) : Person(firstName, lastName) {
    val id: Int

    init {
        id = _id
    }

    override fun getName() : String {return "Tutor: ${super.getName()}"}

    override fun getAddress(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class Undergraduate(firstName: String) : Student(firstName, "", 1) {}

class Postgraduate(firstName: String) : Student(firstName, "", 1) {}

interface XmlSerializer<T> {
    fun toXml(item: T)
}