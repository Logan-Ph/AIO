#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string reversedString(string str){
    reverse(str.begin(),str.end());
    return str;
}

string convertString(string str){
    for (char &i:str){
        if (islower(i)){
            i = toupper(i);
        }else if (isupper(i))
        {   
            i = tolower(i);
        }
    }
    return str;
}

int main(){
    string str = "Good Morning";
    cout << convertString(str) << endl;
    cout << reversedString(str) << endl;
}