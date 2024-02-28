fun main() {
    // Stage 1, 2, 3
    var x: Int

    var number = readln().toInt()
    when {
        number % 2 == 0 -> {
            println("Even")
            number *= 4
            if (number > 0) number *= -1
            println(number)
        } else -> {
            println("Odd")
            number *= 5
            if (number > 0) number *= -1
            println(number)
        }
    }
    // Stage 4
    val yearBirth = readln().toInt()
    x = yearBirth / 100
    if (yearBirth == 0) {
        println("1st century AD")
    } else if (yearBirth > 0) {
        if (yearBirth == x * 100) println("${x}st century AD") else println("${x + 1}st century AD")
    } else {
        if (yearBirth == x * 100) println("${x * -1}st century BC") else println("${x * -1 + 1}st century BC")
    }
}