package objects

class Course(val id: Int, val title: String) {

}

//object keyword is used to create singletons, internally Kotlin creates a class and
//and immediately creates the instance
//remember that singletons make code hard to test and reuse...
//we can make objects to implements interfaces or extend classes, in that sense, objects are just the same
//as classes
object Courses {
    var allCourses = arrayListOf<Course>()

    fun initialized() {
        allCourses.add(Course(1, "Kotlin Fundamentals"))
    }
}