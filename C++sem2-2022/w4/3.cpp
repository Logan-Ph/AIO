#include <algorithm>
#include "iostream"
#include "cstring"
using namespace std;

void reverseString(string &str){
    reverse(str.begin(), str.end());
}

void convertString(string &str){
    for (char &c : str){
        if (isupper(c)){
            c = tolower(c);
        }else if (islower(c)){
            c = toupper(c);
        }
    }
}

void change(int &var1){
    var1 = 20;
    cout << var1 << endl;
}

int main(){
    string str1,str2;
    cout << "Enter the string number 1: " << endl;
    getline(cin,str1);
    cout << "Enter the string number 2: " << endl;
    getline(cin,str2);

    reverseString(str1);
    cout << "String number 1 after reversed: " << str1 <<endl;

    convertString(str2);
    cout << "String number 2 after converted: " << str2 <<endl;
}