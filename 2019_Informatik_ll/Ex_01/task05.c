/**
	Task: 05
	Exersize: 01
	Informatik II, FS19, UZH
	Author: Oliver Strassmann
*/

// ?: if lines 31/35 get commented out programm stops working

#include <stdio.h>
#include <string.h>


int compare( char a, char b ) {
	
	int result = 999; // initialize to some random value other than -1, 0, 1, if char is not a letter we'll get this nr
	
	int asciiA = a;
	int asciiB = b;

	// check if both letters are the same
	if ( asciiA - 32 == asciiB ) { return 1; } // a is uppercase of b, a should come first
	else if ( asciiA + 32 == asciiB ) { return -1; } // b is uppercase of a
	// else convert them both to uppercase 
	else {
		if( asciiA >= 97 ) { asciiA -= 32; }
		if( asciiB >= 97 ) { asciiB -= 32; }
	}

	// check that char is a letter
	if ( asciiA + asciiB >= 130 && asciiA + asciiB <= 180  ) {
		if( asciiA < asciiB ) { return -1; }
		else if( asciiA > asciiB ) { return 1; }
		else { return 0; }
	}

	//return result;
}


void insertionSort( char a[], int n ) {
	
	int key, temp;

	for( int i = 1; i <= n; i++ ) {

		key = a[i];

		while( compare( a[i], a[i-1] ) == -1 && i >= 1 ) {
			// swap
			temp = a[i];
			a[i] = a[i-1];
			a[i-1] = temp;

			i--;	// go to next element	
		}
		
		a[i] = key;
	}
	
}


int main() {
	
	char inputStr[100];

	// get user input
	printf( "Type a string: ");
	scanf( "%s", inputStr );

	// handle main task	
	int length = strlen( inputStr );
		
	insertionSort( inputStr, length );

	// feedback to user
	printf( "Sorted string: %s\n", inputStr );

	return 0;

}
