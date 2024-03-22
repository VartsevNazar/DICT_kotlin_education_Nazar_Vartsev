fun printGreetings() {
    println("""
        Це гра Камінь-ножиці-папір.
        Введіть камінь, ножиці або папір:
    """.trimIndent())
}

fun main(){
    printGreetings()
    val gameRules = listOf("камінь", "ножиці", "папір")
    while (true) {
        val choosingAComputer = gameRules.random()
        val userSelection = try { readln() } catch (e: NullPointerException) { continue }
    }
}