/**
	Exersize: 06
	Task: 04 - Singly Linked List
	Informatik II, FS19, UZH
	Author: Oliver Strassmann
*/

#include <stdio.h>
#include <stdlib.h>

struct node {
	int val;
	struct node* next;
};

struct list {
	struct node* head;
}myList;

struct list* init( ){
	// init list
	struct list* myList = malloc(sizeof(struct list));
	myList->head = ( struct node* ) malloc( sizeof( struct node ) );
	myList->head->next = ( struct node* ) malloc( sizeof( struct node ) );	

	return myList;
}

int size( struct list* listA ) {
	// returns number of elements in a list
}

void appendAtTail( struct list* listA, int val ) {

}

void appendAtHead( struct list* listA, int val ) {
	
	// create new node
	struct node* newHead = ( struct node* ) malloc( sizeof ( struct node ) );
	newHead->val = val; // assign corresponding value

	// next-node equals old head
	newHead->next = listA->head;
	
	// point list->head to new node
	listA->head = newHead;
	
}

void appendAtPosition( struct list* listA, int val, int i ) {}

void reverse( struct list* listA ) {}

void clear( struct list* listA ) {}

void deleteVal( struct list* listA, int val ) {}

void delete( struct list* listA, int i ) {}

void print( struct list* listA ) {}

void avg( struct list* listA ) {}


int main() {
	
	// init list
	struct list* myList = init();

	appendAtHead( myList, 9 );

	printf( "\nRoot val: %d \tnext val: %d\n", myList->head->val, myList->head->next->val );

	return 0;

}
