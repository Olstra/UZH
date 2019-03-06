/**
	Exersize: 03
	Informatik II, FS19, UZH
	Author: Oliver Strassmann

    Detects scedule conflicts between 2 calendars
*/

#include <stdio.h>


struct timeslot {
    float init;
    float end;
};


int conflictsCalculator( struct timeslot I[], int nI, struct timeslot P[], int nP) {

	int nrOfConflicts = 0;

	printf( "conflicting slots = " );

	// go through all items in both arrays
	for (int i = 0; i < nI; i++) {
	for (int j = 0; j < nP; j++) {

	    // beginning of I is inside P time slot
	    if (I[i].init >= P[j].init && I[i].init < P[j].end) {
		// conflict
		printf("( %d, %d ) ", i, j);
		nrOfConflicts++;
	    }
	    // end of I is inside P time slot
	    else if (I[i].end > P[j].init && I[i].end <= P[j].end) {
		// conflict
		printf("( %d, %d ) ", i, j);
		nrOfConflicts++;
	    }
	    // special case:  slot P is sub-set of slot I (_(_)__)
	    else if (P[j].init > I[i].init && P[j].end < I[i].end) {
		// conflict
		printf("( %d, %d ) ", i, j);
		nrOfConflicts++;
	    }

	}
	}

	printf( "\n" );

	return nrOfConflicts;

}


int main() {

	struct timeslot slots_I[100];
	struct timeslot slots_P[100];
	float temp;	

	// nr of slots counters, help counter	
	int nI = 0;
	int nP = 0;
	int tempC = 0; 

	printf ( "Type elements of I seperated by spaces (non-number to stop): " );
	while ( scanf( "%f", &temp ) ) {
		if ( tempC % 2 == 0 ) { slots_I[nI].init = temp; }
		else { slots_I[nI].end = temp; nI++; }
		
		tempC++;	
	} 

	getchar();
	tempC = 0;
	printf ( "Type elements of P seperated by spaces (non-number to stop): " );
	while ( scanf( "%f", &temp ) ) {
		if ( tempC % 2 == 0 ) { slots_P[nP].init = temp; }
		else { slots_P[nP].end = temp; nP++; }
		
		tempC++;	
	} 

	printf( " conflicts = %d ", conflictsCalculator( slots_I, nI, slots_P, nP ) );
	printf( "\n" );

	return 0;

}
