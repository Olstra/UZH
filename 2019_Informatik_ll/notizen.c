#include <stdio.h>

/**
   scanf( " %s ", a ) != scanf( "%s", a ) !!!

*/



int main() {
  
	int a = 1000000;
	int b = 2000000;
	int c = a * b;
	
	printf( "________________" );
	prinf( "Pass uf mit integers:\n" );
	printf("a * b = %d\n", c);

	printf( "_____________" );
	
	////////////////////////////////////////////////////
	
	// Read sentences untill \newline 
	char inputString[100];
	scanf( "%[^\n]", inputString ); 



  return 0;
}
