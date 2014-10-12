#include<iostream>
#include<stdlib.h>
using namespace std;
struct Node {
  int data;
  Node* next;
};

int main(int numarg, char* argv[]) {
  Node* head = NULL;
  int N = atoi(argv[1]);
  for (int i = 0; i<N; i++) {
    Node* tmp = new Node;
    tmp -> data = i;
    tmp -> next = head;
    head = tmp;
  }

  Node* current = head;
  while (NULL != current) {
    cout<< current -> data<<endl;
    current = current -> next;
  }
}
