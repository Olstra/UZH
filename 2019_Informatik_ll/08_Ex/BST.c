/**
 * Exersize: XY
 * Task: xx
 * Algorithms and Data structures
 * Spring 2019, UZH
 * Author: Oliver Strassmann
*/ 

#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
	int val;
	struct TreeNode* left;
	struct TreeNode* right;
};


// helper functions // // // // // // // // // // // // // // // // // // // // // // 

struct TreeNode* createNode(int val){
	struct TreeNode* newNode = (struct TreeNode*)malloc(sizeof(struct TreeNode));
	newNode->val = val;
	newNode->left = newNode->right = NULL;

	return newNode;
}

struct TreeNode* findParent(struct TreeNode* root, struct TreeNode* node){
	struct TreeNode* parent = NULL;
	struct TreeNode* curr = root;

	while(curr != node && curr != NULL){
		parent = curr;
		(node->val < curr->val) ? (curr = curr->left) : (curr = curr->right);
	}
	return parent;
}

// // // // // // // // // // // // // // // // // // // // // // // // // // // //  

void insert(struct TreeNode** root, int val) {	
	struct TreeNode* newNode = createNode(val);
	
	// case root: it's the first node we insert 
	if(*root == NULL){
		*root = newNode; return;
	}

	struct TreeNode* behind; 
	struct TreeNode* curr = *root;
	
	while(curr != NULL){
		behind = curr;
		// check for duplicates 
		if(behind->val == val){ printf("No duplicates allowed."); return; }

		// check if new val goes into left or right subtree 
		if(val < curr->val){
			curr = curr->left; // newNode->val is samller, go left
		}
		else{ curr = curr->right; }
	}	

	// insert node as left/right child
	(val < behind->val) ? (behind->left = newNode) : (behind->right = newNode);
}

struct TreeNode* search(struct TreeNode* node, int val){
	// if node was found return that node otherwise return NULL
	if(node == NULL || node->val == val){ return node; }	
	// search for node
	if(node->val < val){ search(node->right, val); }
	else{ search(node->left, val); } // no duplicates, see insert()...
}

struct TreeNode* findMinimum(struct TreeNode* root){
	struct TreeNode* minimum = NULL;
	struct TreeNode* curr = root;

	while(curr != NULL){
		minimum = curr;
		curr = curr->left; 
	}
	return minimum;
}


void delete(struct TreeNode** root, int val){
	// init needed nodes	
	struct TreeNode* node = *root; // node we want to delete
	struct TreeNode* parent = NULL;
	struct TreeNode* succsessor = NULL;

	// find value
	while(node != NULL && node->val != val){
		parent = node;
		(val < node->val) ? (node = node->left) : (node = node->right);
	}
	if(!node){ printf("Value not found!"); return; }

	// case node has no children	
	if(node->right == NULL && node->left == NULL){ 
		// case node is root
		if(node == *root){ *root = NULL; return; }		
		// case node is leaf
		(parent->left == node) ? (parent->left = NULL) : (parent->right = NULL); 
	}
	// case node has 2 children
	else if(node->left != NULL && node->right != NULL){ 
		// get the values we need to re-point	
		succsessor = findMinimum(node->right);
		parent = findParent(*root, succsessor);
		
		node->val = succsessor->val; // assign new value to node

		parent->left = succsessor->right; // repoint subtree
		
		free(succsessor); 
		return;
	}
	// case node has 1 child
	else { 
		// find out if it has right or left child
		(node->left != NULL) ? (succsessor = node->left) : (succsessor = node->right);
	
		// point parent to node's child	
		if(parent){ (parent->left == node) ? (parent->left = succsessor) : (parent->right = succsessor); } 
		// case root with 1 child
		else{ *root = succsessor; }
	}
	
	free(node); // delete node 
}

void print(struct TreeNode* node){
	// in order print
	if(node != NULL){
		print(node->left);
		printf("%d ", node->val);
		print(node->right);
	}	
}

int main(){

	// init tree
	struct TreeNode* root = createNode(4);

	// add some test values to tree
	int values[] = {2, 3, 8, 6, 7, 9, 12, 1};
	for(int i = 0; i < 8; i++){ insert(&root, values[i]); }

	print(root);
	// struct TreeNode* temp = search(root, 8);
	// printf("\nTemp node val: %d", temp->right->val);
	// delete some values
	int delVals[] = {4, 7, 2};
	delete(&root, 4);
	// for(int i = 0; i < 3; i++){ delete(&root, delVals[i]); }	
	printf("\nroot: %d", root->val);
	print(root);

	return 0;

}
