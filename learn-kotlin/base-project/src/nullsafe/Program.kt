package nullsafe

fun main(args: Array<String>) {
    var m: Meeting2? = null
    var newMeeting = Meeting2()

    //this doesn't compile Kotlin treat them as different types, one is Meeting and the other is Meeting?
    //newMeeting = m

    closeMeeting(newMeeting)
    //Same thing, I can't pass a Meeting? where a Meeting is expected
    //closeMeeting(m)

    println(closeMeeting2(m))

    //We can force it like this, but the use of !! is not recommended
    //in this case the line below will throw a NullPE
    //newMeeting = m!!

    //Assume closeMeetingNonNull is not our code, we can pass a nullable and we can't fix th function.
    //This is were we use 'let'
    //It is basically about using a lambda to make the null check for us.
    var r = m?.let {closeMeetingNonNull(m) }
    //r is null since the function was never called, m is null
    println(r)
}

fun closeMeetingNonNull(m: Meeting2): Boolean? {
    return if(m.canClose) m.close()
    else false
}

fun closeMeeting(m: Meeting2): Boolean? {
    return if(m.canClose) return m.close()
    else false
}

fun closeMeeting2(m: Meeting2?): Boolean? {
    //m? means "call canClose iff m is not null" but now m?.canClose could evaluate to null, so we need to test for "== true"
    return if(m?.canClose == true) return m.close()
    else false
}

class Meeting2 {
    val canClose: Boolean = false
    //Kotlin always want us to initialized properties, but sometimes we won't do that immediately, some other code
    //will do it later. One option is to declare the property as Nullable, but that is a code smell.
    //Instead we can use lateinit in Kotlin.
    lateinit var address: Address

    fun close(): Boolean {
        return true
    }

    fun save(o: Any) {
        //Only does the cast is o is not null
        val saveable = o as? ISaveable
        saveable?.save()
    }

    fun init(address: Address) {
        this.address = address
    }
}

interface ISaveable {
    fun save()
}

class Address {}