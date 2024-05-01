fun printGreetings() {
    println("""
        This is a Rock-Paper-Scissors game.
        Enter rock, paper, scissors or !exit to exit the game:
    """.trimIndent())
}

fun checkWhoWon(gameRulesX: List<String>, stringUser: String, stringComputer: String): String {
    val x = gameRulesX.size / 2
    val k: Int
    if (stringUser !in gameRulesX) return "Wrong"
    if (stringUser == stringComputer) return "Draw"
    when {
        gameRulesX.indexOf(stringUser) == x -> {
            k = 1
            if (gameRulesX[x + k] == stringComputer) return "Computer"
            else if (gameRulesX[x - k] == stringComputer) return "User"
        }
        gameRulesX.indexOf(stringUser) < x -> {
            k = 1
            if (gameRulesX[k] == stringComputer) return "Computer"
            else if (gameRulesX[gameRulesX.size - 1] == stringComputer) return "User"
        }
        gameRulesX.indexOf(stringUser) > x -> {
            k = 0
            if (gameRulesX[k] == stringComputer) return "Computer"
            else if (gameRulesX[gameRulesX.size - 1 - 1] == stringComputer) return "User"
        }
    }
    return ""
}

fun printWhoWon(winnerX: String, choosingAComputerX: String) {
    when (winnerX) {
        "Wrong" -> println("There is no such option")
        "Draw" -> {
            println("Draw")
            println("The computer chose: $choosingAComputerX")
        }
        else -> {
            println("Win: $winnerX.")
            println("The computer chose: $choosingAComputerX")
        }
    }
}

fun main() {
    printGreetings()
    val gameRules = listOf("rock", "paper", "scissors")
    while (true) {
        val choosingAComputer = gameRules.random()
        val userSelection: String? = readlnOrNull()
        if (userSelection == null) {
            println("Finished reading data")
            break
        }
        if (userSelection == "!exit") break
        val winner = checkWhoWon(gameRules, userSelection, choosingAComputer)
        printWhoWon(winner, choosingAComputer)
    }
}