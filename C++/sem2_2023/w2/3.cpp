#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

int main(int argc, char const *argv[])
{
    string str;
    cout << "PLease enter the string: ";
    getline(cin, str);
    for (char c : str)
    {
        cout << c << " ";
    }
    cout << endl;

    double n = 1.234;
    cout << setfill('0') << setw(9) << fixed << setprecision(3) << n << endl;

    cout << setprecision(2);
    cout << n << endl;

    int x;
    cout << "Enter the decimal value: ";
    cin >> hex >> x;
    cin.ignore(0,'\n');
    cout << dec << x;
    cout << " " << "0x" << hex << x << endl;


    double *p_scores { new double[5]{1,2,3,4,5}};
    int i = 0;
    while (i<5){
        cout << *(p_scores+i)<< " ";
        i++;
    }
}
