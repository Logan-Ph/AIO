#include <iostream>
#include <string>
using namespace std;

int main(int argc, char const *argv[])
{
    // 1st solution
    /*
    int n =0;
    int reversed_num = 0;
    cout << "Please enter the number to reverse: ";
    cin >>n;

    while (n!=0)
    {
        reversed_num = reversed_num *10 + (n%10) ;
        n /= 10;
    }
    cout << "The number after reversed: "<< reversed_num;    
    */
    
    // second solution
    string n ;
    cout << "Please enter the number to reverse: ";
    cin >>n;
    n = string(rbegin(n),rend(n));
    cout << "The number after reversed: "<< n;

}
