/**
	Task: 01
	Exersize: 03
	Informatik II, FS19, UZH
	Author: Oliver Strassmann
*/

#include <stdio.h>


int whatDoesItDo( int A[], int n ) {

	int counter = 0;
	int val = 0;
	int* B = A;	
	int C[n]; 

	for ( int i = 0; i < n; i++ ) {
		for ( int j = 0; j < n; j++ ) {
			if ( A[i] == B[j] ) { 
				C[j] = val;
				val = val + 1;
			}		
		}
		val = 1;	
	}

	for ( int i = 0; i < n; i++ ) {
		if ( C[i] == 2 ) {
			counter = counter + 1;
		}
	}

	return counter;
}



int main() {

	int inputA[100];
	int n = 0;
	int temp;


	printf( "\nDo you have INTegrity? Show me: " );	
	while ( scanf( "%d", &temp ) ) {
		inputA[n] = temp;
		n++;
	}
	
	printf( "You're not one of a kind: " );
	printf( "\n%d\n", whatDoesItDo( inputA, n ) );

	return 0;

}
