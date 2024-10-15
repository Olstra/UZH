import java.io.File

fun main(args: Array<String>) {

    var myFSM = StateMachine()
    myFSM.parseStates()
    myFSM.parseTransitions()

    myFSM.execute()
}