/**
	Task: 04
	Exersize: 01
	Informatik II, FS19, UZH
	Author: Oliver Strassmann
*/

#include <stdio.h>


// Sorting Algorithms
void bubbleSort(int A[], int n );

void selectionSort( int A[], int n );

void insertionSort( int A[], int n );

// helpert functions
void printArr( int A[], int n );
void swap( int *a, int *b );


int main() {

	int selection;

	int input[] = { 22, 6, 1, 41, 26, 41, 47, 8 };

	int inputLen = sizeof( input ) / sizeof( input[0] );

	printf( "\nWELCOME TO VISUALIZATION FOR SORT ALGORITHMS\n\n[1] Bubble Sort\n[2] Selection Sort\n[3] Insertion Sort\n\nSelect your algorithm: " );
	scanf("%d", &selection );

	switch( selection ) {
		case 1:
			bubbleSort( input, inputLen );
			break;
	
		case 2:
			selectionSort( input, inputLen );	
			break;
		
		case 3:	
			insertionSort( input, inputLen );		
			break;

		default: break;
	}
	
	printArr( input, inputLen );

	return 0;

}


void swap( int *a, int *b ) {
	// change pointers
	
	int temp = *a;
	*a = *b;
	*b = temp;
}

void printArr( int A[], int n ) {

	for( int i = 0; i < n; i++ ) {
		printf( "%d ", A[i] );	
	}
	printf( "\n" );
}

void bubbleSort( int A[], int n ) {
	int temp;

	for( int i = 0; i < n; i++ ) {
		printf( "Iteration %d:\n", i+1 );
		printArr( A, n );

		for( int j = n-2; j >= i; j-- ) {
			if( A[j] > A[j+1] ) {
				swap( &A[j], &A[j+1] );
				
				printArr( A, n );
			}
		}
	}


}

void selectionSort( int A[], int n ) {
	// places current min at beginning of sub-array
	int min, temp;

	for( int i = 0; i < n; i++ ) {
		min = i;	// set default min

		for( int j = i; j < n; j++ ) {
			if( A[j] < A[min] ) { min = j; } // find current min			

		}
		
		// update sorted sub-array
		if( A[i] > A[min] ) {
			swap( &A[i], &A[min]  );
		}
	}
}

void insertionSort( int a[], int n ) {

	int key, temp;

        for( int i = 1; i < n; i++ ) {

                key = a[i];

                while( a[i] < a[i-1] && i >= 1 ) {
                        swap( &a[i], &a[i-1] );
                        i--;    // go to next element
                }

                a[i] = key;
        }
}
