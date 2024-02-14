fun main() {
    println("""
        Hello! My name is DICT_Bot.
        Please, remind me your name.
    """.trimIndent())
    val stringUsername = readln()
    println("What a great name you have, $stringUsername!")
    println("""
        Let me guess your age.
        Enter remainders of dividing your age by 3, 5 and 7.
    """.trimIndent())
    val remainder3 = readln().toInt()
    val remainder5 = readln().toInt()
    val remainder7 = readln().toInt()
    val age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105  // user age calculation
    println("Your age is $age!")
    println("Now I will prove to you that I can count to any number you want.")
    val number = readln().toInt()
    for (i in 0..number) println("$i!")
}