class StateMachine {

    // all states of this statemachine
    private val states: MutableList<State> = mutableListOf()
    private var initialState = State()

    private fun getState(inputName: String): State? {
        return states.firstOrNull {
            it.name == inputName
        }
    }

    fun init(){
        // TODO
    }

    fun parseStates(){
        var lines: MutableList<String> = mutableListOf(
            "Basement floor: The subway station below the mall",
            "*Ground floor: Perfumes",
            "First floor: Men's apparel",
            "Second floor: Women's apparel",
            "Third floor: Restaurants",
            "+Exit: Exit",
            "+Subway: Exit"
        )
        var temp = ""
        var skip = false
        for(line in lines) {
            var state = State()
            if( line.trim() != "" ){ // skip empty lines
                for (char in line) {
                    when (char) {
                        ':' -> {
                            state.name = temp.trim()
                            temp = "" // reset string for description
                        }
                        '*' -> state.isInitialState = true
                        '+' -> state.isEndingState = true
                        '#' -> {
                            skip = true
                            break // ignore comments
                        }
                        else -> temp += char
                    }
                }
            }
            else{ skip = true }
            if(!skip) {
                state.description = temp.trim()
                states.add(state)
                if(state.isInitialState){
                    initialState = state
                }
                temp = ""
            }
            skip = false
        }
    }

    fun parseTransitions(){
        var lines: MutableList<String> = mutableListOf(
            "Ground floor (exit) Exit: Leaving on foot",
            "Basement floor (subway) Subway: Leaving by train",
            "Basement floor (elevator -1) Basement floor: Not going anywhere",
            "Ground floor (elevator -1) Basement floor: Taking the elevator",
            "First floor (elevator -1) Basement floor: Taking the elevator",
            "Second floor (elevator -1) Basement floor: Taking the elevator",
            "Third floor (elevator -1) Basement floor: Taking the elevator",
            "Basement floor (elevator 0) Ground floor: Taking the elevator",
            "Ground floor (elevator 0) Ground floor: Not going anywhere",
            "First floor (elevator 0) Ground floor: Taking the elevator",
            "Second floor (elevator 0) Ground floor: Taking the elevator",
            "Third floor (elevator 0) Ground floor: Taking the elevator",
            "Basement floor (elevator 1) First floor: Taking the elevator",
            "Ground floor (elevator 1) First floor: Taking the elevator",
            "First floor (elevator 1) First floor: Not going anywhere",
            "Second floor (elevator 1) First floor: Taking the elevator",
            "Third floor (elevator 1) First floor: Taking the elevator",
            "Basement floor (elevator 2) Second floor: Taking the elevator",
            "Ground floor (elevator 2) Second floor: Taking the elevator",
            "First floor (elevator 2) Second floor: Taking the elevator",
            "Second floor (elevator 2) Second floor: Not going anywhere",
            "Third floor (elevator 2) Second floor: Taking the elevator",
            "Basement floor (elevator 3) Third floor: Taking the elevator",
            "Ground floor (elevator 3) Third floor: Taking the elevator",
            "First floor (elevator 3) Third floor: Taking the elevator",
            "Third floor (elevator 3) Third floor: Not going anywhere",
            "Second floor (elevator 3) Third floor: Taking the elevator"
        )

        var temp = ""
        var state = State()
        var transitionName = ""
        var transitionDescr = ""
        var toStateName = ""

        for(line in lines) {
            for (char in line) {
                when (char) {
                    '(' -> {
                        // remove whitespace before " ("
                        state = getState(temp.trim())!!
                        temp = "" // reset string for description
                    }
                    ')' -> {
                        transitionName = temp.trim()
                        temp = ""
                    }
                    ':' -> {
                        toStateName = temp.trim()
                        temp = "" // reset string for description
                    }
                    else -> temp += char
                }
            }
            transitionDescr = temp.trim()
            val transition = Transition(transitionName, transitionDescr, toStateName)
            state.myTransitions.add(transition)
            // reset variables
            temp = ""
            transitionName = ""
        }
    }

    fun execute(){
        var currentState = initialState
        do{
            // print current state info
            print("[" + currentState.name + "] ")
            print(currentState.description)
            println()

            // transition to next state
            var input = readLine()
            var nextStateName = currentState.transition(input!!.trim())
            if(nextStateName != null){
                currentState = getState(nextStateName)!!
            }
            else{ println("Sorry, try again!") }
        }while(!currentState.isEndingState)
    }
}