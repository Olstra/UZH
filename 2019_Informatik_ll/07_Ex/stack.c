#include <stdio.h>
#include <stdlib.h>

const int INITIAL_STACK_SIZE = 5;	

struct stack{
	const int* root;		// points to "struct stackArray[0]"
	int size;		// keep track of total size of struct stack
	int topElement; // save index of element at top of struct stack (LIFO) 
};

void initialize(struct stack *s){
	
 	// create array to save elements in
	const int elements[INITIAL_STACK_SIZE];

	// set values of stack struct	
	s->size = INITIAL_STACK_SIZE; 
	s->root = elements[0]; // point root to array
	s->topElement = 0;	// [0] element remains empty as root
}

int isEmpty(struct stack *s){

	if(s->topElement <= 0) return 1; // "TRUE"

	return 0; // "FALSE" else stack is not empty

}

int push(struct stack *s, int value){
	
	s->topElement++; // go to next index to save new element

	// check if we've run out of space
	if(s->topElement >= s->size){
		// make stack bigger
		s->size += INITIAL_STACK_SIZE;
		const int newArray[s->size];
		s->root = newArray[0];

		// copy elements to new array
		for(int i = 1; i < s->size; i++){
			newArray[i] = s->root[i];
		} 
	}
	
	// add new element
	newArray[s->topElement] = val;

	return s->topElement;

}

int pop(struct stack *s){
	
	// check if struct stack is empty
	if(isEmpty(s) == 1) return -1;

	int deletedVal = s->root[s->topElement];

	s->topElement--; // reduce index of "last element"	
	
	return deletedVal;	

}

int compareStack(struct stack *sA, struct stack *sB){
	
	// if stacks have different sizes they're not equal
	if(sA->topElement != sB->topElement) return 0;

	for(int i = 1; i < sA->topElement; i++){
		if(sA->root[i] != sB->root[i]) return 0;
	}
	
	return 1; // sA and sB are equal
}

void printStack(struct stack *s){

	int temp = 1;

	printf("\nFrom the top of the stack:");
	while(temp <= s->topElement){
		printf(" %d", s->root[temp]);
		temp++;	
	}

}


int main(){
	struct stack* myStack = (struct stack*) malloc( sizeof(struct stack));
	
	initialize(myStack);

	return 0;
}
