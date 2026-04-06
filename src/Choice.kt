// First, define a simple data class for each scene
data class Scene(
    val text: String,
    val choices: Map<String, String> = emptyMap()  // choice -> nextSceneId
)

// Main Game class
class Choice {

    private val scenes = mapOf(
        "start" to Scene(
            text = "You wake up in a hen house. Do you go to the DOOR or stay in the nesting BOX?",
            choices = mapOf(
                "door" to "outside",
                "box" to "box"
            )
        ),

        "outside" to Scene(
            text = "You look outside and see a PUDDLE and a FOOD trough. Where do you go?",
            choices = mapOf(
                "puddle" to "puddle",
                "food" to "food"
            )
        ),

        "box" to Scene(
            text = "There is a scratching at the door. Do you HIDE or INVESTIGATE?",
            choices = mapOf(
                "hide" to "hide_success",
                "investigate" to "fox"
            )
        ),

        "puddle" to Scene(
            text = "You walk up to the muddy puddle. There is a paw print in it. Do you IGNORE it or INVESTIGATE it?",
            choices = mapOf(
                "ignore" to "fox",           // bad ending
                "investigate" to "safe"      // good path
            )
        ),

        "food" to Scene(
            text = "There is food in the trough and some spilt on the ground. Do you eat from the TROUGH or eat from the GROUND?",
            choices = mapOf(
                "trough" to "safe",
                "ground" to "fox"
            )
        ),

        "hide_success" to Scene(
            text = "You hide and the scratching goes away. You survived! Well done.",
            choices = emptyMap()   // ending
        ),

        "safe" to Scene(
            text = "You made it safely. Congratulations, you are a very clever chicken!",
            choices = emptyMap()
        ),

        "fox" to Scene(
            text = "Suddenly a fox appears... You are eaten. Game Over.",
            choices = emptyMap()
        )
    )

    fun play() {
        println("What is your name?")
        val name = readln().trim()
        println("\nHi, $name! Let's begin your adventure...\n")

        var currentSceneId = "start"

        while (true) {
            val scene = scenes[currentSceneId]
                ?: run {
                    println("Error: Scene not found!")
                    return
                }

            // Print the story text
            println(scene.text)

            // If there are no choices → this is an ending
            if (scene.choices.isEmpty()) {
                println("\n--- The End ---")
                break
            }

            // Show available choices
            println("Your choices: ${scene.choices.keys.joinToString(" or ") { it.uppercase() }}")

            // Get player input
            val input = readln().trim().lowercase()

            // Find next scene
            val nextSceneId = scene.choices[input]

            if (nextSceneId != null) {
                currentSceneId = nextSceneId
                println() // empty line for readability
            } else {
                println("Invalid choice. Try again.\n")
                // stays in the same scene
            }
        }
    }
}