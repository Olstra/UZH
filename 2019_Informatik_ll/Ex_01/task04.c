/**
	Task: 04
	Exersize: 01
	Informatik II, FS19, UZH
	Author: Oliver Strassmann
*/


#include <stdio.h>


int main() {

	int A[100];
	int B[100];
	int lenA = 0;
	int lenB = 0;
	char temp;

	
	// scan A
	printf( "Values of A separated by spaces (non-number to stop): " );
	while( scanf( "%d", &A[lenA] ) ) { lenA++; }
        scanf( "%s", &temp); // ignore 'end' char

	// scan B
	printf( "Values of B separated by spaces (non-number to stop): " );
	while( scanf( "%d", &B[lenB] ) ) { lenB++; }
        scanf( "%s", &temp); // ignore 'end' char


	// print result

	int iA = 0;
	int iB = 0;

	while( iA < lenA && iB < lenB ) {
			
		if( A[iA] > B[iB] ) { printf( "%d ", A[iA] ); iA++; } // if A is bigger print it and go to next number
		else if( B[iB] > A[iA] ) { printf( "%d ", B[iB] ); iB++; } // same if B bigger
		else { 
			// if both numbers are equal print both and increase both indexes
			printf( "%d %d ", A[iA], B[iB] ); iA++; iB++;
		}
	}	

	printf( "\n" );
	
	return 0;

}
