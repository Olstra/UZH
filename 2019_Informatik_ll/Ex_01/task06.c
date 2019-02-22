/**
	Task: 04
	Exersize: 01
	Informatik II, FS19, UZH
	Author: Oliver Strassmann
*/


// TODO 
// getArrSize
// swap

#include <stdio.h>


// Sorting Algorithms
void bubbleSort(int A[] );

void selectionSort( int A[] );

void insertionSort( int A[] );

// helpert functions
void printArr( int A[] );
void swap( int a, int b );
int getArrSize( int A[] );

int main() {

	int selection;

	int input[] = { 22, 6, 1, 41, 26, 41, 47, 8 };

	printf( "\nWELCOME TO VISUALIZATION FOR SORT ALGORITHMS\n\n[1] Bubble Sort\n[2] Selection Sort\n[3] Insertion Sort\n\nSelect your algorithm: " );
	scanf("%d", &selection );

	switch( selection ) {
		case 1:
			bubbleSort( input );
			break;
	
		case 2:
			selectionSort( input );	
			break;
		
		case 3:	
			insertionSort( input );		
			break;

		default: break;
	}
	
	printArr( input );

	return 0;

}

int getArrSize( int A[] ) {
	int size = sizeof( A ) / sizeof( int );
	return size;
}

void printArr( int A[] ) {
	int n = 8; //getArrSize ( A );

	for( int i = 0; i < n; i++ ) {
		printf( "%d ", A[i] );	
	}
	printf( "\n" );
}

void bubbleSort( int A[] ) {
	int n = 8; //getArrSize( A );
	int temp;
	int swaped = 0;

	do {
		for( int i = 1; i < n; i++ ) {
			swaped = 0;
			//for( int j = i-1; j <= i+1; j++ ) {
			if( A[i] < A[i-1] ) {
				//swap
				temp = A[i];
				A[i] = A[i-1];
				A[i-1] = temp;

				swaped++;
			}
		//	}
		}
	} while( swaped != 0);


}

void selectionSort( int A[] ) {}

void insertionSort( int a[] ) {

	int n = 8; // getArrSize( a );
	int key, temp;

        for( int i = 1; i <= n; i++ ) {

                key = a[i];

                while( a[i] < a[i-1] && i >= 1 ) {
                        // swap
                        temp = a[i];
                        a[i] = a[i-1];
                        a[i-1] = temp;

                        i--;    // go to next element
                }

                a[i] = key;
        }
}
