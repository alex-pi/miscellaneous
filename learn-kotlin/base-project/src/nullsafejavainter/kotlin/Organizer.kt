package nullsafejavainter.kotlin

import nullsafejavainter.java.AddressInter
import nullsafejavainter.java.MeetingInter

fun main(args: Array<String>) {
    val m = MeetingInter()

    //here the exception happens when we try to assing title to a Nonnullable
    //If the Java code uses the @Nullable annotation we can have a compile time error
    val title: String? = m.meetingTitle()

    println(title)

    //This won't compile since the parameter is annotated with @NotNull
    //m.addTitle(null)
    //Kotlin has 3 ways to indicate type mismatch
    //1) String! (platform type) means it can be null, but it doesn't know
    //var i: Int = m.titleCanBeNull()
    //2) String? that is a nullable type. Declared via @Nullable or other Kotlin code using '?'
//    var i: Int = m.meetingTitle()
    //3) String It knows it is not null, declared as @NotNull, so this is just the normal type mismatch

    //this again throws an exception, we can use Kotlin code to deal with the fact the the method can return null
    //one way is with Elvis operator and declaring a default value
    val t: String = m.titleCanBeNull() ?: "NA"
    println(t)
}

//When overriden Java classes we can decide if the return types will be Nullable or not
class HomeAddress: AddressInter {
    override fun getFirstAddress(): String {
        return ""
    }
}

class WorkAddress: AddressInter {
    override fun getFirstAddress(): String? {
        return ""
    }
}