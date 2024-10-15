import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.random.Random

fun main(args: Array<String>) {

    // function call
    val c = 6 // TODO get user input for this
    val n = 50
    var pot = 1000.0

    // user prompt
    var userGuesses = Array(c){1}
    var drawnNrs    = Array(c){0}
    var randomNr    = 0

    // get user input for nrs
    do{
        var validInput  = true
        // TODO change c to variable
        println("Enter $c numbers separated by any number of spaces (any numbers after $c will be ignored): ")
        var userInput = readLine()

        // extract numbers through regex
        var regex = "(-\\d+|\\d+)".toRegex()
        var matches = regex.findAll(userInput.toString())
        var idx = 0
        // put numbers into our array
        matches.forEach { f ->
            if(idx < c){
                userGuesses[idx] = f.value.toInt()
                idx++
            }
        }

        // exit if user typed "quit"
        if(userInput.equals("quit")){ return }
        else{
            // check validity of input
            for(i in 0 until c-1){
                if(userGuesses[i] < 1 || userGuesses[i] > n){
                    println("Invalid input: all numbers must be between 1 and $n!")
                    validInput = false
                    break
                }
                // check nrs are unique
                for(j in i until c-1){
                    if(userGuesses[i] == userGuesses[j+1]){
                        println("Invalid input: no duplicates allowed!")
                        validInput = false
                        break
                    }
                }
            }
        }
    }while(!validInput)

    println("Shuffling.....")
    // delay(5000)
    for(i in 0 until c-1){

        do{
            randomNr = Random.nextInt(1, n)
        }while(randomNr == drawnNrs[i]) // you can't draw the same nr twice

        println(randomNr)

        drawnNrs[i] = randomNr // save into drawn nrs

        // wait 2s
        //delay(2000)

    }

    // Print out how many numbers match and the amount of prize money won in this game.
    // matched nrs
    println("Matched numbers: ")
    var correctGuesses = 0
    for(i in 0 until c-1){
        if(userGuesses[i] == drawnNrs[i]){
            print(userGuesses[i])
            print(" ")
            correctGuesses++
        }
    }
    // money won
    var ratio : Double = (correctGuesses / c).toDouble()
    var prize = pot.pow( ratio.roundToInt()).roundToInt()
    println("The money won in this game was $prize CHF")

}
