/**
        Task: 01 - main
        Exersize: 02
        Informatik II, FS19, UZH
        Author: Oliver Strassmann
*/

#include <stdio.h>
#include "01_a_LCM.h"
#include "01_b_GCD.h"


int main() {

	int x, y, choice;

	printf( "\n-----GCD-LCM-----\n\n" );
	printf( "[1] Greatest Common Divisor\n[2] Least Common Multiplier\n[3] LCM with GDC\n\nYour choice: " );
	scanf( "%d", &choice );
	printf( "First number: " ); scanf( "%d", &x );
	printf( "Second number: " ); scanf( "%d", &y );


	switch( choice ) {
		
		case 1:
			printf( "\nGCD of %d and %d is: %d\n", x, y, GCD( x, y ) );
			break;
		case 2:
			printf( "\nLCM of %d and %d is: %d\n", x, y, LCM( x, y ) );
			break;
		case 3:
			printf( "\nLCM: %d ", LCM_withGDC( x, y ) );
		default: 
			printf( "I don't feel like doing that..." );
			break;	

	}


        return 0;

}

