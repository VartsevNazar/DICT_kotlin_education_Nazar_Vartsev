import kotlin.system.exitProcess

fun exitProcessViaNull(string: String?) {
    if (string == null) {
        println("Data entry completed")
        exitProcess(0)
    }
}

fun main() {
    println("Enter the number of rows:")
    var n = readlnOrNull()
    exitProcessViaNull(n)
    val numberRows = try { n!!.toInt() } catch (e: NumberFormatException) {
        println("Must be a number\n")
    }

    println("Enter the number of seats in each row:")
    n = readlnOrNull()
    exitProcessViaNull(n)
    val seatsInRow = try { n!!.toInt() } catch (e: NumberFormatException) {
        println("Must be a number\n")
    }
}