#include <iostream> 
#include <string>

using namespace std;

template <typename type>
void swapp(type &a, type &b){
    type c = a;
    a = b;
    b = c;
}

int main(){
    string a = "hello";
    string b = "hi";
    swapp<string>(a,b);
    cout << a << endl;
    cout << b << endl;
}