#include <iostream>
#include <iomanip>
#include <string>
#include <algorithm>
#include <regex>

using namespace std;

int main(int argc, char const *argv[])
{
    // first solution
    // string x;
    // cout << "Please enter the number in hexadecimal form: ";
    // cin >> x;

    // if (size(x) == 4 && x.substr(0, 2) == "0x")
    // {
    //     string hexNum = x.substr(2);
    //     if (all_of(begin(hexNum), end(hexNum), [](char c)
    //                 { return isxdigit(c); }))
    //     {
    //         cout << x << endl;
    //     }
    //     else
    //     {
    //         cout << "Invalid hexadecimal form ";
    //     }
    // }
    // else
    // {
    //     cout << "Invalid hexadecimal form ";
    // }

    // second solution
    string x;
    regex hexReg("0[xX][0-9a-fA-F]+");
    cout << "Please enter the number in hexadecimal form: ";
    cin >> x;

    if(regex_match(x,hexReg)){
        cout << "Got valid hexadecimal value: " << x << "\n";
    }else{
        cout << "Invalid hexadecimal point \n";
    }
    
}
