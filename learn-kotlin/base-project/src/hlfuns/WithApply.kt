package hlfuns

import java.util.*

class Meeting {
    var Title: String = ""
    var When: Date = Date()
    var Who = mutableListOf<String>()

    fun create(){}
}

fun main(args: Array<String>) {
    val m = Meeting()

    //With might look as a reserved word but is just a function
    with(m) {
        Title = "Meeting with Charles"
        When = Calendar.getInstance().time
        Who.add("Brian")
    }

    //apply uses the receiver of the call (m in this case) as an implicit reference inside the lambda body,
    //it also returns the same object again.
    //this is useful to build complex initializations
    m.apply {
        Title = "Meeting with Charles"
        When = Calendar.getInstance().time
        Who.add("Brian")
    }.create()
}