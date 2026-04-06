//This is a chose your own adventure game written in Kotlin.
//By Angela Murray

//instructions on how to play the game
fun instructions(){
    println("Welcome to Choose Your Own Adventure: Hen House! ")
    println("Rules: ")
    println("1) Read the prompt.")
    println("2) Make your choice by typing the word that is UPPERCASE.")
    println("3) have fun!")
}

// play will start the game and loop until the player chooses to end the game.
fun play(){
    var keepPlaying: Boolean = true
    while (keepPlaying) {
        val myGame = Game() //first attempt at the game
        myGame.coop() // *** runs the game***

        val secondGame = Choice() //second attempt at the game using Map of
//        secondGame.play() // *** runs the game ***

        println("Do you want to play again? yes or no")
        when (readln().trim().lowercase()) {
            "yes", "y" -> {
                println("Starting a new round...")
            }
            else -> {
                keepPlaying = false
                println("Thanks for playing!")
            }
        }
    }
}

// Everything goes through the main function.
fun main () {
    instructions()
    play()
}