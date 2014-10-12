#include<iostream>
#include<stdlib.h>
using namespace std;
class Node {
public:
  Node();
  ~Node();
  void add(Node* p);
  void set_data(int d);
  void set_next(Node* n);
  int get_data();
  Node* get_next();
private:
  Node* head;
  int data;
  Node* next;
};

Node::Node()
{
}

Node::~Node()
{
}

Node* Node::get_next() {
  return this -> next;
}

int Node::get_data() {
  return this -> data;
}

void Node::set_next(Node* n) {
  this -> next = n;
}

void Node::set_data(int d) {
  this -> data = d;
}

void Node::add(Node* p) {
  p -> next = head;
  head = p;
}
  
int main(int numarg, char* argv[]) {
  // Node* head = NULL;
  // int N = atoi(argv[1]);
  // for (int i = 0; i<N; i++) {
  //   Node* tmp = new Node;
  //   tmp -> data = i;
  //   tmp -> next = head;
  //   head = tmp;
  // }

  // Node* current = head;
  // while (NULL != current) {
  //   cout<< current -> data<<endl;
  //   current = current -> next;
  // }
  return 0;
}
