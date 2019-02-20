/**
	Task: 05
	Exersize: 01
	Informatik II, FS19, UZH
	Author: Oliver Strassmann
*/


#include <stdio.h>


int compare( char a, char b ) {
	
	int result = 999; // initialize to some random value other than -1, 0, 1, if char is not a letter we'll get this nr
	
	int asciiA, asciiB;

	// check that char is a letter
	if () {
		if( asciiA < asciiB ) { result = -1; }
		else if( asciiA > asciiB ) { result = 1; }
		else { result = 0; }
	}

	return result;
}


void insertionSort( char a[], int n ) {
	
	int key, neighbour;

	// switch ( compare( ) )
	for( int i = 0; i < n-1; i++ ) {

		while( compare( a[i], a[i-1] ) == -1 && i > 1 ) {
			// swap
			temp = a[i];
			a[i] = a[i-1]
			a[i-1] = temp;
			i--;	
		}
		
		a[i] = key;





	}

}



int main() {



	return 0;

}

