#include <iostream>

using namespace std;


template<int N> 
class factorial {
public:
    static const int value = N*factorial<N-1>::value;  
};

template<> 
class factorial<0> { 
public:
  static const int value = 1;
};

int main() {
  cout << factorial<2>::value << endl; 
}