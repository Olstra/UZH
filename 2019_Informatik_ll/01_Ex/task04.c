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
    char temp[100];


    // scan A
    printf( "Values of A separated by spaces (non-number to stop): " );
    while( scanf( "%d", &A[lenA] ) == 1 ) { lenA++; }
    scanf( "%s", &temp[0] ); // ignore 'end' char

    // scan B
    printf( "Values of B separated by spaces (non-number to stop): " );
    while( scanf( "%d", &B[lenB] ) == 1 ) { lenB++; }
    scanf( "%s", &temp[0]); // ignore 'end' char


    // print result

    int idxA = 0;
    int idxB = 0;

    while( idxA < lenA && idxB <  lenB ) {

        if( A[idxA] > B[idxB] ) {
            printf( "%d ", A[idxA] );
            idxA++;
        }
        else if( A[idxA] < B[idxB] ) {
            printf( "%d ", B[idxB] );
            idxB++;
        }
        else {
            printf( "%d %d ", A[idxA], B[idxB] );
            idxA++; idxB++;
        }
    }

    // print remaining array if any 
    while ( idxA < lenA ) { printf( "%d ", A[idxA] ); idxA++; }
    while ( idxB < lenB ) { printf( "%d ", B[idxB] ); idxB++; }

    printf( "\n" );

    return 0;

}
