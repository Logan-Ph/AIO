#include <iomanip>
#include <iostream>

using namespace std;

int main(){
    cout << 100 << endl;
    cout.setf(ios::hex,ios::basefield);
    cout.setf(ios::showbase);
    cout << 100 << endl;
}