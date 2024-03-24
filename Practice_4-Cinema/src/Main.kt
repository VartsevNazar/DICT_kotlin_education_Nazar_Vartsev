import kotlin.system.exitProcess

fun exitProcessViaNull(string: String?) {
    if (string == null) {
        println("Data entry completed")
        exitProcess(0)
    }
}

fun convertingStringToIntLoop(string: String): Int {
    while (true) {
        try {
            return string.toInt()
        }
        catch (e: NumberFormatException) {
            println("Must be a number\n")
        }
    }
}

fun printMenu() {
    println()
    println("""
        1. Show the seats
        2. Buy a ticket
        3. Statistics
        0. Exit
    """.trimIndent())
}

fun main() {
    println("Enter the number of rows:")
    var n = readlnOrNull()
    exitProcessViaNull(n)
    val numberRows = convertingStringToIntLoop(n!!)

    println("Enter the number of seats in each row:")
    n = readlnOrNull()
    exitProcessViaNull(n)
    val seatsInRow = convertingStringToIntLoop(n!!)
    val cinemaGrid = List(numberRows) { List(seatsInRow) { "S" } }
}