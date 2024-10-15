/**
 * Class representing a transition.
 * Input format: Ground floor (exit) Exit: Leaving on foot
 *  "Ground floor"          = current state we want to transition out of
 *  "exit"                  = transition keyword
 *  "Exit: Leaving on foot" = transition description
 *  "Exit"                  = name of "next" state
 * */

data class Transition(
    val name: String,
    val description: String,
    val toStateName: String, // name of the state we want to transition to
)
