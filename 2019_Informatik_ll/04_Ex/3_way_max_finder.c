/**
	Exersize: 04
	Task: 02
	Informatik II, FS19, UZH
	Author: Oliver Strassmann

	Finds max number in an array using 3 way divide and conquer method.
		l = left => first index in array, = 0
		r = right => last element in array, = length of array
*/

#include <stdio.h>


int findMaxOf3( int a, int b, int c ) {

	if ( a >= b && a >= c ) { return a; }
	else if ( b > a && b>= c ) { return b; }
	else return c;

}


int count = 1;
int maxFinder( int A[], int l, int r ) {

	// special cases

	if( r-l == 1 ) return A[l];	// array contains only 1 e
printf( "\n %d-Max: %d\n", count, A[l] );
	count++;
	//if( r == 2 ) return ( A[0] > A[1] ) ? A[0] : A[1]; // array contains only 2 e 
	//if ( r-l <= 1 ) return A[l];
	// recursive call untill partitions of 1

	int mid1 = ( l + r ) / 3; // = 1/3
	int mid2 = ( ( l+ r) / 3 ) * 2;	 // = 2/3
	printf( "\nmid1: %d mid2: %d\n", mid1, mid2 );
	
	int a = maxFinder( A, l, mid1-1 );	
	int b = maxFinder( A, mid1, mid2-1 );		
	int c = maxFinder( A, mid2, r-1 ); 

	// return maximum out of 3 nums	
	return findMaxOf3( a, b, c );
}




int main() {

	int A[] = { 2, 90 };
	
	int B[] = { 90, 5, 70, 8 };

	int C[] = { 90 };

	int D[] = { 56, 3, 4, 5, 5, 90, 90, 34, 1, 2, 2 };

	int E[] = { 90, 90, 90 };

	//int testNums[] = { A, B, C, D, E };

	int testLens[] = { 2, 3, 1, 11, 3 };

	int nrOfTests = 5;

	printf ( "\nMax: %d\n", maxFinder( B, 0, 3 ) );


	return 0;

}
