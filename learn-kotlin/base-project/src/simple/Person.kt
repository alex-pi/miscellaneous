package simple

class Person(var Name: String) {

    fun sayName() {
        println("Name is $Name")
    }

    fun greetings(func: (s:String) -> Unit) {
        func(Name)
    }
}