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

fun printCinemaGrid(cinemaGridX: List<MutableList<String>>) {
    println("\nCinema:")
    var s = " "
    var x = 1
    for (i in cinemaGridX) {
        s += " $x"
        x += 1
    }
    println(s)
    x = 1
    for (i in cinemaGridX) {
        println("$x ${i.joinToString(" ")}")
        x += 1
    }
}

fun interactionProgram(cinemaGridX: List<MutableList<String>>) {
    var boolX: Boolean
    do {
        boolX = false
        val choice = readAndConvertingLoop()
        when (choice.toString()) {
            "1" -> printCinemaGrid(cinemaGridX)
            "2" -> buyTicket(cinemaGridX)
            "3" -> statisticsCinema()
            "0" -> exitProcess(0)
            else -> {
                println("\nEnter the menu item number:")
                boolX = true
            }
        }
    } while (boolX)
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
                    println("\nTicket price: \$10")
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
        Percentage: ${"%.2f".format(percentage)}%
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
        interactionProgram(cinemaGrid)
    }
}