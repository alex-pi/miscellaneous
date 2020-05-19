package generics

import javax.print.attribute.standard.Destination

fun main(args: Array<String>) {
    val meetings = listOf(BoardMeeting(), StaffMeeting(), BoardMeeting())

    val board = meetings.filterByType<BoardMeeting>()

    println(board)

    val financeMeetings = mutableListOf(FinanceMeeting())
    val meetings2 = AllMeetings<FinanceMeeting>(financeMeetings)

    //AllMeetings<FinanceMeeting> is not a subtype of AllMeetings<Meeting>
    //for this to work we need to use the keyword "out" which tells the compiler:
    //I'm not adding anything to the list, just taking/using out elements of the list.
    //so there is no risk the code would add anything which does not corresponds to the
    //declared type of meetings2

    attendAllMeetings(meetings2)
    val meetings4 = mutableListOf(FinanceMeeting(), FinanceMeeting())
    val meetings3 = mutableListOf<Meeting>()
    copyThings(meetings4, meetings3)
}

//In Kotlin we can ask for generic types at runtime if the function is inlined.
//Then we just specified reified in front of the type.
inline fun <reified T> List<*>.filterByType() : List<T> {
    val returnList = mutableListOf<T>()

    for(item in this){
        if(item is T)
            returnList.add(item)
    }

    return returnList
}

fun <T : Meeting> buildMeeting(meetingClass: Class<T>, action: (T) -> Unit): T {
    val m = meetingClass.newInstance()
    action(m)
    return m
}

//Instead of passing the Class type we can ask for it at runtime using reified
inline fun <reified T: Meeting> buildMeeting(action: (T) -> Unit): T {
    val m = T::class.java.newInstance()
    action(m)
    return m
}

//We can avoid code duplication calling the first function from the second.
//But we can't use inline because we are passing a lambda(action) to be used later on.
//We need to tell Kotlin that the parameter action is not inlined
inline fun <reified T: Meeting> buildMeeting2(noinline action: (T) -> Unit): T {
    return buildMeeting(T::class.java, action)
}

open class Meeting {
    fun attend() {}
}

class BoardMeeting: Meeting() {}

class StaffMeeting: Meeting() {}

class FinanceMeeting: Meeting() {}

//THEN THE ALL TIME BIG PROBLEM!!! VARIANCE!!
//HOW KOTLIN SOLVES THIS?

// ABOUT KEYWORD "OUT"
//THIS IS CALLED DECLARATION SITE VARIANCE AND IT IS USUALLY MORE ELEGANT THAN JAVA'S CALL SITE VARIANCE
//CALL SITE VARIANCE IS STILL NEEDED IN SOME CASES
class AllMeetings<out T: Meeting>(val meetings: List<T>) {
    val count: Int = meetings.count()

    operator fun get(i :Int) = meetings[i]
}

fun attendAllMeetings(meetings: AllMeetings<Meeting>) {
    for (i in 0 until meetings.count)
        meetings[i].attend()
}

//CALL SITE VARIANCE EXAMPLE
fun <T> copyThings(source: MutableList<T>, destination: MutableList<in T>) {
    for (m in source)
        destination.add(m)
}