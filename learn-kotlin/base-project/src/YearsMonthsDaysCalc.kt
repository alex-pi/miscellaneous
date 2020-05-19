fun main(args: Array<String>) {
    println("Hello World")

    /*val ymd0 = intArrayOf(2,7,15)
    val ymd1 = intArrayOf(0,3,22)
    val ymd2 = intArrayOf(0,2,14)
    val ymd3 = intArrayOf(2,0,19)
    val ymd4 = intArrayOf(0,10,29)
    val ymd5 = intArrayOf(1,0,29)
    val ymd6 = intArrayOf(0,5,29)
    val ymd7 = intArrayOf(1,11,15)
    val ymd8 = intArrayOf(1,3,14)

    var all = listOf(ymd0, ymd1, ymd2, ymd3, ymd4, ymd5, ymd6, ymd7, ymd8)*/


    /*val ymd0 = intArrayOf(2,7,15)
    val ymd1 = intArrayOf(0,3,22)
    val ymd2 = intArrayOf(0,2,14)
    val ymd3 = intArrayOf(2,0,19)
    val ymd4 = intArrayOf(0,10,29)
    val ymd5 = intArrayOf(1,0,29)
    val ymd7 = intArrayOf(1,11,15)

    var all = listOf(ymd0, ymd1, ymd2, ymd3, ymd4, ymd5, ymd7)*/

    /*val ymd0 = intArrayOf(2,7,15)
    val ymd1 = intArrayOf(0,3,22)
    val ymd2 = intArrayOf(0,2,14)
    val ymd3 = intArrayOf(2,0,19)
    val ymd4 = intArrayOf(0,10,29)
    val ymd5 = intArrayOf(1,0,29)
    val ymd7 = intArrayOf(1,11,15)
    val ymd8 = intArrayOf(1,3,14)

    var all = listOf(ymd0, ymd1, ymd2, ymd3, ymd4, ymd5, ymd7, ymd8)*/

    /*val ymd0 = intArrayOf(2,7,15)
    val ymd1 = intArrayOf(2,0,19)
    val ymd2 = intArrayOf(0,7,29)
    val ymd3 = intArrayOf(1,11,15)

    var all = listOf(ymd0, ymd1, ymd2, ymd3)*/

    val ymd0 = intArrayOf(2,7,15)
    val ymd1 = intArrayOf(2,0,19)

    var all = listOf(ymd0, ymd1)

    /*val ymd1 = intArrayOf(0,3,22)
    val ymd2 = intArrayOf(0,2,14)
    val ymd3 = intArrayOf(2,0,19)

    var all = listOf(ymd1, ymd2, ymd3)*/

    var r = all.reduce { acc, ints ->
        var days = acc[2] + ints[2]
        var monthsFromDays: Int = days / 30
        acc[2] = days % 30

        var months = acc[1] + ints[1] + monthsFromDays
        var yearsFromMonths: Int = months / 12
        acc[1] = months % 12
        acc[0] = acc[0] + ints[0] + yearsFromMonths
        acc
    }

    r.forEach { e ->
        print("$e, ")
    }
}