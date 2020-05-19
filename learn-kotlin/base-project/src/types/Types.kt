package types

//Public by default
interface Time {
    fun setTime(hours: Int, mins: Int = 0, secs: Int = 0)
    //Like in Java 8 we can provide default implementations in interfaces to be able to evolve interfaces
    //without affecting existing implementations, basically is like an abstract class...
    fun setTime(time: KevinTime) = setTime(time.hours)
}

interface EndOfTheWorld {
    fun setTime(time: KevinTime) {}
}

class KevinTime {
    var hours: Int = 0
    var minutes: Int = 0
    var seconds: Int = 0
}

//No implements or extends keywords are used
//the colon means both
class YetiTime : Time, EndOfTheWorld {

    //Since there's a conflict with the setTime method, Kotling won't know which one should be called
    //when a client tries it by using an instance of YetiTime, we need to tell it which one should be called
    //for YetiTime, we can choose to call both!!! ain't that cool?
    override fun setTime(time: KevinTime) {
        //we can use <> to tell Kotlin which setTime implementation to call,
        //in this case we choose to call both
        super<Time>.setTime(time)
        super<EndOfTheWorld>.setTime(time)
    }

    //We have to use the override keyword
    override fun setTime(hours: Int, mins: Int, secs: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}