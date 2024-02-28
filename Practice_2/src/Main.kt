fun main() {
    // Stage 1, 2, 3
    var x: Int
    var y: Int

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
    // Stage 5
    val list1 = readln().split(' ')
    val listResult1 = mutableListOf<Int>()
    for (i in 0..<list1.count())
        listResult1.add(list1[i].toInt())
    println(listResult1.minOrNull())  // minimum value output
    // Stage 6
    val list2 = readln().split(' ')
    val listResult2 = mutableListOf<Int>()
    for (i in 0..<list2.count())
        listResult2.add(list2[i].toInt())
    x = listResult2.maxOrNull()!!
    listResult2.remove(x)
    y = listResult2.maxOrNull()!!
    println("max1: $x, max2: $y")
}