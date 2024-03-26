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

fun interactionProgram(choice: String, cinemaGridX: List<MutableList<String>>) {
    when (choice) {
        "1" -> for (i in cinemaGridX) println("\n${i.joinToString()}")
        "2" -> buyTicket(cinemaGridX)
        "3" -> statisticsCinema()
        "0" -> exitProcess(0)
    }
}

fun buyTicket(cinemaGridX: List<MutableList<String>>) {
    var boolX: Boolean
    do {
        try {
            boolX = false
            println("\nEnter a row number:")
            val rowX = readAndConvertingLoop()
            println("Enter a seat number in that row:")
            val seatX = readAndConvertingLoop()
            when {
                cinemaGridX[rowX][seatX] == "S" -> cinemaGridX[rowX][seatX] = "B"
                cinemaGridX[rowX][seatX] == "B" -> {
                    println("\nThat ticket has already been purchased!")
                    println("Enter another location")
                    boolX = true
                }
            }
        }
        catch (e: IndexOutOfBoundsException) {
            println("\nWrong input!")
            println("Enter another location")
            boolX = true
        }
    } while (boolX)
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
    val numberRows = readAndConvertingLoop()

    println("Enter the number of seats in each row:")
    val seatsInRow = readAndConvertingLoop()
    val cinemaGrid = List(numberRows) { MutableList(seatsInRow) { "S" } }
    val purchasedTickets = 0
    val percentage = 0
    val currentIncome = 0
    val totalIncome = 360
    while (true) {
        printMenu()
        val userSelectionMenu = readAndConvertingLoop()
        interactionProgram(userSelectionMenu.toString(), cinemaGrid)
    }
}