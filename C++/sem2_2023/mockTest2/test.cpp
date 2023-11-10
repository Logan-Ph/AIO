#include <iostream>
#include <memory>

using namespace std;

int main(){
    unique_ptr<int> p = make_unique<int>(12);
    cout << *p << endl;
}