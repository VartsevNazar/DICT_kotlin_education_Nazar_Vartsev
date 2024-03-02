import javax.lang.model.type.NullType

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
    var list = readln().split(' ')
    var listResult = mutableListOf<Int>()

    for (i in 0..<list.count())
        listResult.add(list[i].toInt())
    println(listResult.minOrNull())  // minimum value output
    // Stage 6
    list = readln().split(' ')
    listResult = mutableListOf<Int>()

    for (i in 0..<list.count())
        listResult.add(list[i].toInt())
    x = listResult.maxOrNull()!!
    listResult.remove(x)
    y = listResult.maxOrNull()!!
    println("max1: $x, max2: $y")
    // Stage 7
    var stringInput = readln()

    if (stringInput.isEmpty()) {
        println(emptyList<NullType>())
    } else {
        list = stringInput.split(' ')
        listResult = mutableListOf<Int>()

        x = 0
        y = 0
        for (i in 0..<list.count())
            listResult.add(list[i].toInt())
        for (i in listResult)
            if (i > 0) x += 1 else {
                if (i < 0) y += i
            }
        println(listOf<Int>(x, y))
    }
    // Stage 8
    stringInput = readln()
    val listVowels = "aeiouy".toList()

    x = 0
    for (i in stringInput)
        if (i in listVowels) x += 1
    println("Vowels: $x")
    // Stage 9
    stringInput = readln()

    if (stringInput.isEmpty()) {
        println("")
    } else {
        x = stringInput.length / 2
        if (stringInput.length % 2 == 0) {
            println("" + stringInput[x - 1] + stringInput[x])
        } else {
            println("" + stringInput[x])
        }
    }
    // Stage 10
    println("Enter rows and columns separated by spaces to draw the multiplication table:")
    stringInput = readln()

    if (stringInput.isEmpty() || " " !in stringInput) println("") else {
        list = stringInput.split(" ")
        val listMultidimensional = MutableList(list[0].toInt()) { mutableListOf(0) }

        for (i in 1..list[0].toInt()) {
            listMultidimensional[i - 1].remove(0)  // remove 0 from rows
            for (j in 1..list[1].toInt()) {
                listMultidimensional[i - 1].add(i * j)  // create a multiplication table
            }
        }
        for (i in listMultidimensional) {
            println(i.joinToString(" "))
        }

    }
}