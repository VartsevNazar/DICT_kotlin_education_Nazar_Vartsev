fun main() {
    // Greeting message
    println("""
        Hello! My name is DICT_Bot.
        Please, remind me your name.
    """.trimIndent())
    val stringUsername = readln()
    println("What a great name you have, $stringUsername!")
    // Age calculation
    println("""
        Let me guess your age.
        Enter remainders of dividing your age by 3, 5 and 7.
    """.trimIndent())
    val remainder3 = readln().toInt()
    val remainder5 = readln().toInt()
    val remainder7 = readln().toInt()
    val age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105  // user age calculation
    println("Your age is $age!")
    // Account from 0 to number
    println("Now I will prove to you that I can count to any number you want.")
    val number = readln().toInt()
    for (i in 0..number) println("$i!")
    // User test
    println("Let's test your programming knowledge.")
    println("""
            Why do we use methods?
            1. To repeat a statement multiple times.
            2. To decompose a program into several small subroutines.
            3. To determine the execution time of a program.
            4. To interrupt the execution of a program.
        """.trimIndent())
    while (true) {
        val answer = readln()
        if (answer == "2") {
            println("""
                Completed, have a nice day!
                Congratulations, have a nice day!
            """.trimIndent())
            break
        } else {
            println("Please, try again.")
        }
    }

}