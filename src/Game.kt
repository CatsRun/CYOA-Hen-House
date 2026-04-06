// main game play
class Game {
    fun coop() {
        println("What is your name?")
        val name = readln().trim()
        println("Hi, $name. You wake up in a hen house. Do you go to the DOOR or stay in the nesting BOX?")

//        first level choice

        val choice1 = readln().trim().lowercase()

        var result = when (choice1) {
            "door" -> "You look outside and see a PUDDLE and FOOD trough. Where do you go?"
            "box" -> "There is a scratching at the door. Do you HIDE or INVESTIGATE?"
            else -> "You fall back to sleep. "
        }
        println(result)

//        second level choice

        val choice2 = readln().trim().lowercase()

        result = when (choice1) {
            "door" -> when (choice2) {
                "puddle" -> "You walk up to the muddy puddle. There is a paw print in it. Do you IGNORE it or INVESTIGATE it?"
                "food" -> "There is food in the trough and some spilt on the ground. Do you eat from the TROUGH or eat from the GROUND?"
                else -> "You are eaten by a fox."
            }

            "box" -> when (choice2) {
                "hide" -> "You hide and the scratching goes away." //end game
                "investigate" -> "You look out the door. A fox eats you."
                else -> "It was all a dream..."
            }
            else -> "Game over"
        }
        println(result)

//      third level

        val choice3 = readln().trim().lowercase()

        result = when (choice1) {
            "door" -> when (choice2) {
                "puddle" -> when (choice3) {
                    "ignore" -> "A fox eats you."
                    "investigate" -> "You see a fox near by. You run back inside and are safe."
                    else -> "end"
                }
                "food" -> when (choice3) {
                    "trough" -> "A fox sneaks up behind you and eats you."
                    "ground" -> "You see a shadow and run away. You are safe."
                    else -> "end"
                }
                else -> "end"
            }
            "box" -> when (choice3) {
                "investigate" -> "A fox sneaks up behind you and eats you."
                else -> "end"
            }
            else -> "end"
        }
        println(result)
    }
}