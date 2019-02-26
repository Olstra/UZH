/**
	Task: 01 - b
	Exersize: 02
	Informatik II, FS19, UZH
	Author: Oliver Strassmann
*/

#include <stdio.h>


int GCD( int x, int y ) {
	
	// implementation of Euclid's algorithm
	
	if( x == y ) { return x; }
	
	if( x > y ) { GCD( x - y, y ); }
	else{ GCD( y - x, x ); }

}
