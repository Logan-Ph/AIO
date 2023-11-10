#include <iostream>
#include <algorithm>
#include <numeric>
#include <iomanip>
using namespace std;

int main(int argc, char const *argv[])
{
    int array[5] = {};

    for (size_t i = 0; i < 5; i++)
    {
        cout << "Please enter the number ";
        cin >> array[i];
    }

    cout << setprecision(2);
    cout << "The max number in the array is " << *max_element(begin(array),end(array)) << endl;
    cout << "The average of the array is " << double (accumulate(begin(array),end(array),0) / (int) size(array));
    
}
