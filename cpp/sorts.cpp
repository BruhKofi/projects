#include<iostream>
#include<stdlib.h>
#include<assert.h>
#include<ctime>
using namespace std;

class Timer {
private:
  clock_t start;
public:
  Timer()
  {
    start = clock();
  }

  ~Timer()
  {
    start = NULL;
  }

  double elapsed_time() {
    clock_t end = clock();
    return (double) (end - start)/CLOCKS_PER_SEC;
  }
};


/*
  Declarations
*/
int* makeArray(int N);
void printArray(int* arr, int N);
void insertionSort(int* arr, int N);
void exch(int* a, int i, int j);
void mergeSort(int* a, int N);
void mergeSort(int* a, int lo, int hi);
void merge(int* a, int lo, int mid, int hi);
bool isSorted(int* a, int N);
int randomInt(int N);
void shuffle(int* a, int N);
void quickSort(int* a, int N);
void quickSort(int* a, int lo, int hi);
int partition(int* a, int lo, int hi);
const int CUTOFF = 7;

// main
int main(int numars, char* argv[]) {
  int N = atoi(argv[1]);

  Timer time;
  int* a = makeArray(N);
  insertionSort(a, N);
  cout<<"Insertion sort time : "<<time.elapsed_time()<<endl;


  a = makeArray(N);
  clock_t start = clock();
  mergeSort(a, N);
  clock_t stop = clock();
  cout<<(double)(stop-start)/CLOCKS_PER_SEC<<endl;
  cout<<"Mergesort time : "<<time.elapsed_time()<<endl;


  a = makeArray(N);
  quickSort(a, N);
  cout<<"Quicksort time : "<<time.elapsed_time()<<endl;
                                                              
  return 0;
}

int randomInt(int N) {
  double r = rand()/(double)(RAND_MAX);
  return r*N;
}

int* makeArray(int N) {
  int *a = new int[N];
  for (int i = 0; i<N; i++) {
    a[i] = randomInt(N);
  }
  return a;
}

void shuffle(int* a, int N) {
  for (int i = 0; i<N; i++) {
    int r = i + randomInt(N-i);
    exch(a, r, i);
  }
}

bool isSorted(int* a, int N) {
  for (int i = 1; i<N; i++) {
    if (a[i-1] > a[i]) return false;
  }
  return true;
}

void printArray(int* a, int N) {
  for (int i = 0; i<N; i++) {
    cout<<a[i]<<endl;
  }
}

// insertion sort
void insertionSort(int* a, int N) {
  for (int i = 0; i<N; i++) {
    for (int j = i; j>0 && a[j-1] > a[j]; j--) exch(a, j-1, j);
  }
  assert(isSorted(a, N));
}

void insertionSort(int* a, int lo, int hi) {
  for (int i = lo; i<=hi; i++) {
    for (int j = i; j>0 && a[j-1] > a[j]; j--) exch(a, j, j-1);
  }
}

void exch(int* a, int i, int j) {
  int t = a[i];
  a[i] = a[j];
  a[j] = t;
}

// mergesort
void mergeSort(int* a, int N) {
  mergeSort(a, 0, N-1);
}

void mergeSort(int* a, int lo, int hi) {
  if (hi <= lo + CUTOFF) {
    insertionSort(a, lo, hi);
    return;
  }
  int mid = lo + (hi - lo)/2;
  mergeSort(a, lo, mid);
  mergeSort(a, mid+1, hi);
  merge(a, lo, mid, hi);
}

void merge(int* a, int lo, int mid, int hi) {
  int* aux = new int[hi-lo+1];
  for (int k = lo; k<=hi; k++) aux[k] = a[k];
  int i = lo, j = mid+1;
  for (int k = lo; k<=hi; k++) {
    if (i > mid) a[k] = aux[j++];
    else if (j > hi) a[k] = aux[i++];
    else if (aux[i] < aux[j]) a[k] = aux[i++];
    else a[k] = aux[j++];
  }

}

// quicksort
void quickSort(int* a, int N) {
  shuffle(a, N);
  quickSort(a, 0, N-1);
  assert(isSorted(a, N));
}

void quickSort(int* a, int lo, int hi) {
  if (hi <= lo + CUTOFF) {
    insertionSort(a, lo, hi);
    return;
  }
  int j = partition(a, lo, hi);
  quickSort(a, lo, j-1);
  quickSort(a, j+1, hi);
}

int partition(int* a, int lo, int hi) {
  int i = lo, j = hi+1;
  int v = a[lo];
  while (true) {
    while (a[++i]<v) if (i == hi) break;
    while (a[--j]>v) if (j == lo) break;
    if (j <= i) break;
    exch(a, i, j);
  }
  exch(a, lo, j);
  return j;
}

