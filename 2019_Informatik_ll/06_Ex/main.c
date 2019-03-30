#include <stdio.h>

#include "linked_list.c"


int main() {
	
	// init list
	struct list* root = malloc(sizeof(struct list));
	
	init( root, 5 );

	appendAtTail( root, 9 );

	printf( "\nRoot val: %d \tnext val: %d\n", root->head->val, root->head->next->val );

	return 0;

}
