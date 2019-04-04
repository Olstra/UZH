#include <stdio.h>

typedef struct stackADT {
int ∗elements;
int size;
int count;
} stack;

void initialize(stack *s){}

int isEmpty(stack *s){}

int push(stack *s, int value){}

int pop(stack *s){}

int compareStack(stack *sA, stack *sB){}

int printStack(stack *s){}
typedef struct queueADT {
int elements[QUEUE SIZE];
int head;
int count;
} queue;

void initialize(queue *q){}

int enqueue(queue *q, int value){}

int dequeue(queue *q){}

int compareQueue(queue *qA, queue *qB){}


int main(){

	return 0;
}