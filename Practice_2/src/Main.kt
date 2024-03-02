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
    // Stage 7
    val stringInput1 = readln()

    if (stringInput1.isEmpty()) {
        println(emptyList<NullType>())
    } else {
        val list3 = stringInput1.split(' ')
        val listResult3 = mutableListOf<Int>()

        x = 0
        y = 0
        for (i in 0..<list3.count())
            listResult3.add(list3[i].toInt())
        for (i in listResult3)
            if (i > 0) x += 1 else {
                if (i < 0) y += i
            }
        val listX = listOf<Int>(x, y)
        println(listX)
    }
    // Stage 8
    val stringInput2 = readln()
    val listVowels = "aeiouy".toList()

    x = 0
    for (i in stringInput2)
        if (i in listVowels) x += 1
    println("Vowels: $x")
    // Stage 9
    val stringInput3 = readln()

    if (stringInput3.isEmpty()) {
        println("")
    } else {
        x = stringInput3.length / 2
        if (stringInput3.length % 2 == 0) {
            println("" + stringInput3[x - 1] + stringInput3[x])
        } else {
            println("" + stringInput3[x])
        }
    }
}