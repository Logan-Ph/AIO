#include <iostream>
#include <iomanip>

using namespace std;

int main(int argc, char const *argv[]) {
    int a, b;
    cout << "Please enter the coefficient 'a' and 'b' for the linear equation\n";
    cin >> a >> b;
    cout << setprecision(2);
    cout << "Then answer of the equations is " << (double) -b / a;
}
