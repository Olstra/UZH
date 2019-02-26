/**
	Task: 02
	Exersize: 02
	Informatik II, FS19, UZH
	Author: Oliver Strassmann
*/

#include <stdio.h>



int spaces = 6;

void drawTriangle( int d ) {
	

	// recursion end, start of printing chars to screen
	if( d <= 0 ) { return; }
	
	
	
	drawTriangle( d - 1 ); 


	printf( "\n" );
	for( int i = 0; i < spaces; i++ ) { printf( " " ); }
	spaces--;
//printf( "%d", spaces );
	for( int i = d; i >= 0 ; i-- ) {
		printf( "*" );
	}




}

int main() {
	
	int depth;

	printf( "\tWELCOME TO THIS PROGRAM\n" );
	printf( "\tType in depth:" );

	scanf( "%d", &depth );

	printf( "\n" );

	drawTriangle( depth );

	printf( "\n" );

	return 0;

}
