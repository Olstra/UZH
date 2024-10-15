/**
 * Class representing a state.
 * ------------------------
 * Input format examples:
 *  *Ground floor: Perfumes
 *  Third floor: Restaurants
 *  +Exit: Exit
 *  -----------
 *  * = it's an initial state
 *  + = it's a final state
 *  String before ":" = state name
 *  String after ":" = state description
 * ------------------------
 * */
class State() {

    var name = ""
    var description = ""
    var isInitialState = false
    var isEndingState = false
    // all possible transitions out of this state
    var myTransitions: MutableList<Transition> = mutableListOf()

    fun transition(input: String): String? {
        for(transition in myTransitions){
            if(transition.name == input){
                // print transition description, then goto next state
                println(transition.description)
                return transition.toStateName
            }
        }
        return null
    }

}