#include <iostream>
#include <algorithm>
#include <numeric>
#include <iomanip>
#include <string>
using namespace std;

int main(int argc, char const *argv[])
{
    string c = "";
    cout << "Please input the string: ";
    getline(cin, c);
    for (char& i : c){
        if (isupper(i)){
            i = std::tolower(i);
        }else{
            i = std::toupper(i);
        }
    }

    cout << "The string after convert: " << c << endl;
    
}
