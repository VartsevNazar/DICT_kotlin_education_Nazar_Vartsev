fun main() {
    // Stage 1, 2
    var number = readln().toInt()
    when {
        number % 2 == 0 -> {
            println("Even")
            number *= 4
        } else -> {
            println("Odd")
            number *= 5
        }
    }
}