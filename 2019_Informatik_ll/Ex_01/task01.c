/**
	Task: 01
	Exersize: 01
	Informatik II, FS19, UZH
	Author: Oliver Strassmann
*/

// TODO add code for german letters äöü


#include <stdio.h>


int getArraySize( char inputArr[] ) {

	int size;
	
	size = sizeof( inputArr ) / sizeof( char );

	size -= 1; // -1 because of endstring char

	return size;

}

void convertCharacters(char input[]) {

	int ascii;

	int length = getArraySize( input );

	for ( int i = 0; i < length; i++ ) {
		
		ascii = input[i]; // get ascii code pro letter

		// check for letters
		if ( ascii >= 65 && ascii <= 122) {
	
			// convert uppercase to lowercase
			if ( ascii <= 90 ) {
		
				input[i] = ascii + 32;
			}
			// convert lowercase to uppercase
			else {
				input[i] = ascii - 32;
			}

		}  
	}	
}


int main () {

	char inputString[100];

	printf( "Please enter a string: " );
	
	scanf( "%s" , inputString);

	convertCharacters( inputString );

	printf( "Result string: %s\n" , inputString);

	return 0;
}
