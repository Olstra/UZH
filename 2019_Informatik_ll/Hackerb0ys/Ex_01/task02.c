/**
	Task: 02
	Exersize: 01
	Informatik II, FS19, UZH
	Author: Oliver Strassmann
*/


#include <stdio.h>


void handleInput( int x, int y, int len, int nums[] ) {

	printf( "Pairs = " );

	for( int i = 0; i < len; i++ ) {

		if( nums[i] > x && nums[i] < y ) {
		
			printf( "(%d,%d) ", nums[i], i );

		}	

	}

	printf( "\n" );

}


int main() {

	int x, y;

	int length = 0;

	int inputNums[100];	

	char temp[50];	

	printf( "Elements of A separated by spaces (non-number to stop): " );

	// read input
	while( scanf( "%d", &inputNums[length] ) ) {
		length++;
	} 

	scanf( "%s", &temp); // ignore 'end' char

	printf( "Type x: " );
	scanf( "%d", &x );
	
	getchar(); // ignore 'enter'

	printf( "Type y: " );
	scanf( "%d", &y );

	handleInput( x, y, length, inputNums );

	return 0;

}
