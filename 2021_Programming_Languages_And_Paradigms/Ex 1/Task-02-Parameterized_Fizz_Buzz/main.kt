// Programming Languages and Paradigms
// Spring 2021
// Oliver Strassmann
// Excersize 1, task 1
// create FizzBuzz programm in Kotlin

fun main(args: Array<String>) {
    // setup
    var fBArgs = arrayOf(1, 1, 1, 1) // array to store arguments for function
    var validInput = false

    do{
        // get user input for 4 nrs
        println("“Please enter four positive integer numbers (m n x y) separated by one or more blank spaces or type quit:")
        var userInput = readLine()

        // extract numbers through regex
        // match positive or negative digits
        var regex = "(-\\d+|\\d+)".toRegex()
        var matches = regex.findAll(userInput.toString())
        var idx = 0
        matches.forEach { f ->
            // put numbers into our array
            if(idx < fBArgs.size){
                fBArgs[idx] = f.value.toInt()
                idx++
            }
        }

        // exit if user typed "quit"
        if(userInput.equals("quit")){ return }
        else{
            // check that every nr is positive
            var positive = true
            for(element in fBArgs){
                if (element < 0){
                    positive = false
                    break
                }
            }
            if(positive){
                // The first number must be smaller than the second number.
                // The third and fourth numbers must differ.
                if(fBArgs[0] < fBArgs[1] && fBArgs[2] != fBArgs[3]) {
                    validInput = true
                }
            }
        }
    }while(!validInput)

    /*  The Fizz Buzz Program usually prints the numbers from 1 to 100,
        however substituting numbers divisible by 3 with “Fizz”,
        those divisible by 5 with “Buzz” and
        those divisible by both 3 and 5 with “FizzBuzz”
        Range from m to n
        divisible by x or/and y
    */
    fun calculateFizzBuzz(m: Int, n: Int, x: Int, y: Int) {
        for(i in m..n){
            if(i % x == 0 && i % y == 0){
                print("FizzBuzz ")
            }
            else if(i % x == 0){
                print("Fizz ")
            }
            else if(i % y == 0){
                print("Buzz ")
            }
            else{
                print("$i ")
            }
        }
    }

    calculateFizzBuzz(fBArgs[0], fBArgs[1], fBArgs[2], fBArgs[3])

}