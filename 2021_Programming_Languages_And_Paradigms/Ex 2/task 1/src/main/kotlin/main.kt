fun main(args: Array<String>) {

//    val testData_Ints = arrayOf(2, 3, 9, 4, 5, 67)
//    val testData_Floats = arrayOf(2.9, 3.1, 9.9999, 4, 5.0, 67.789456)
//
//    val arraySize = testData_Floats.size-1
//
//    quickSort(testData_Ints, 0, arraySize)
//
//    // print sorted array
//    for(i in 0..arraySize){
//        print(testData_Ints[i])
//        print(" ")
//    }

    // system calls
    Runtime.getRuntime().exec("echo test")

}

// Quicksort
fun quickSort(myData: Array<Int>, left: Int, right: Int){
    val idx = partition(myData, left, right)
    if(left < idx - 1){
        quickSort(myData, left, idx-1) // left partition
    }
    if(idx < right){
        quickSort(myData, idx, right)
    }
}

// partition scheme for QS
fun partition(myData: Array<Int>, l: Int, r: Int): Int {
    var left = l
    var right = r
    val pivot = myData[(left + right)/2]

    while (left <= right) {
        while (myData[left] < pivot) left++
        while (myData[right] > pivot) right--
        if (left <= right) {
            swap(myData, left, right)
            left++
            right--
        }
    }

    return left
}

// helper function that swaps 2 numbers of an array
fun swap(myArray: Array<Int>, a: Int, b: Int){
    val temp = myArray[a]
    myArray[a] = myArray[b]
    myArray[b] = temp
}