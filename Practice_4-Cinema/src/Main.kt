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
                cinemaGridX[rowX][seatX] == "S" -> {
                    cinemaGridX[rowX][seatX] = "B"
                    purchasedTickets += 1
                    percentage = 100.0 / numberSeats * purchasedTickets
                    currentIncome += 10
                    println("Ticket price: \$10")
                }
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
        Number of purchased tickets: $purchasedTickets
        Percentage: $percentage%
        Current income: ${'$'}$currentIncome
        Total income: ${'$'}$totalIncome
    """.trimIndent())
}

private var purchasedTickets = 0
private var percentage = 0.0
private var currentIncome = 0
private var totalIncome = 0
private var numberSeats = 0

fun main() {
    println("Enter the number of rows:")
    val numberRows = readAndConvertingLoop()

    println("Enter the number of seats in each row:")
    val seatsInRow = readAndConvertingLoop()
    val cinemaGrid = List(numberRows) { MutableList(seatsInRow) { "S" } }
    numberSeats = numberRows * seatsInRow
    totalIncome = numberRows * seatsInRow * 10
    while (true) {
        printMenu()
        val userSelectionMenu = readAndConvertingLoop()
        interactionProgram(userSelectionMenu.toString(), cinemaGrid)
    }
}