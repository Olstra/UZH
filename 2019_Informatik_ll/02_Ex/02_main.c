/**
	Task: 02
	Exersize: 02
	Informatik II, FS19, UZH
	Author: Oliver Strassmann
	
	Prints a triangle made of "*"
*/

#include <stdio.h>


int spaces = 50;

void drawTriangle( int d ) {	
	
	// recursion end, start of printing chars to screen
	if( d < 0 ) { return; }

	// recursive call
	drawTriangle( d - 1 ); 

	// after we've reached recusion bottom this code will be called:

	int nrOfStars = d * 2 + 1;

	// print white space for every line
	printf( "\n" ); // start new line
	for( int i = 0; i < spaces; i++ ) { printf( " " ); }
	spaces--;

	// print * for every line	
	for( int i = nrOfStars; i > 0 ; i-- ) { printf( "*" ); }

}


int main() {
	
	int depth;

	printf( "\tWELCOME TO PRINT A TRIANGLE\n" );
	
	printf( "\tType in height:" );

	scanf( "%d", &depth );

	printf( "\n" );

	drawTriangle( depth );

	printf( "\n" );

	return 0;

}
