/**
	Task: 03
	Exersize: 01
	Informatik II, FS19, UZH
	Author: Oliver Strassmann
*/


#include <stdio.h>


void checkFibonacci( int num ) {

	int fibo1 = 0;
	int fibo2 = 1;

	// first check beginning of fibonacci sequence
	if( num == fibo1 || num == fibo2 ) { printf( "Result: TRUE\n" ); return; }

	int temp;
	char falseRes[] = "FALSE";
	char trueRes[] = "TRUE";
	char* result = falseRes; // set default result to "FALSE"

	printf( "Generated Fibonacci sequence: " );
	
	printf( "%d, %d ", fibo1, fibo2 );

	do {
		temp = fibo1 + fibo2;
		printf( "%d, ", temp );
		
		// go to next fibonacci nr
		fibo1 = fibo2;
		fibo2 = temp;

		if( temp == num ) { result = trueRes; } // number is in fibonacci sequence
	
	}while( temp <= num );

	printf( "Result: %s\n", result );

}


int main() {

	int num;

	printf( "Type x: " );
	scanf( "%d", &num );
	
	checkFibonacci( num );

	return 0;

}
