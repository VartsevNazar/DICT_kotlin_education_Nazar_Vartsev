import kotlin.system.exitProcess

fun exitProcessViaNull(string: String?) {
    if (string == null) {
        println("Data entry completed")
        exitProcess(0)
    }
}

fun readAndConvertingLoop(): Int {
    while (true) {
        val s = readlnOrNull()
        exitProcessViaNull(s)
        try {
            return s!!.toInt()
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

//fun buyTicket(cinemaGridX: List<List<String>>) {
//    val boolX = false
//    println()
//    val rowX = readAndConvertingLoop()
//    println()
//    val seatX = readAndConvertingLoop()
//    do {
//        try {
//            when {
//                cinemaGridX[rowX][seatX] != "S" -> {
//                    cinemaGridX[rowX][seatX] = "B"
//                }
//            }
//        }
//    } while (boolX)
//}

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
    val numberRows = readAndConvertingLoop()

    println("Enter the number of seats in each row:")
    val seatsInRow = readAndConvertingLoop()
    val cinemaGrid = List(numberRows) { MutableList(seatsInRow) { "S" } }
    while (true) {
        printMenu()
        val userSelectionMenu = readAndConvertingLoop()
        interactionProgram(userSelectionMenu.toString(), cinemaGrid)
    }
}