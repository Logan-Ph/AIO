#include <iostream>
#include <string>
#include <list>

using namespace std;

template<typename type>
void min3(type a, type b, type c){
    type min_ = min(min(a,b),c);
    cout << "The min of " << a << ", " << b << ", " << c << " is " << min_;
}

int main(){
    min3<string>("Hello","Hi","Morning");
}