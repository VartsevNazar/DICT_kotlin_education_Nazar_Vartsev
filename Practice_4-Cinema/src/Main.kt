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

fun interactionProgram(choice: String, cinemaGridX: List<List<String>>) {
    when (choice) {
        "1" -> for (i in cinemaGridX) println("\n${i.joinToString()}")
//        "2" ->
        "3" -> statisticsCinema()
        "0" -> exitProcess(0)
    }
}

fun statisticsCinema() {
    println()
    println("""
        Number of purchased tickets: 0
        Percentage: 0.00%
        Current income: ${'$'}0
        Total income: ${'$'}360
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
    while (true) {
        printMenu()
        n = readlnOrNull()
        exitProcessViaNull(n)
        val userSelectionMenu = n
        interactionProgram(userSelectionMenu!!, cinemaGrid)
    }
}