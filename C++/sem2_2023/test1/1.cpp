#include <iostream>
#include <string>
#include <algorithm>
#include <fstream>
#include <bits/stdc++.h>

using namespace std;

int sumDigit(int num){
    string total = to_string(num);
    int sum = 0;
    for (char i: total){
        sum+= int(i)-48;
    }
    return sum;    
}

string recPal(int sum){
    int minus = 0;
    int plus = 0;

    int temp_plus = sum;
    int minus_plus = sum;
    while (true)
    {
        string reversed_string = to_string(temp_plus);
        reverse(reversed_string.begin(),reversed_string.end());
        if (reversed_string == to_string(temp_plus))
        {
            break;
        }
        temp_plus+=1;
        plus++;
    }

    while (true)
    {
        string reversed_string = to_string(minus_plus);
        reverse(reversed_string.begin(),reversed_string.end());
        if (reversed_string == to_string(minus_plus) || minus_plus<10)
        {
            break;
        }
        minus_plus-=1;
        minus++;
    }
    
    if (plus > minus){
        return "Minus " + to_string(minus) + " to make it a palindrome.";
    }else if (minus > plus){
        return "Plus " + to_string(plus) + " to make it a palindrome.";
    }else{
        return "Plus or minus " + to_string(plus) + " to make it a palindrome." ;
    }
}


bool checkPal(int num){
    int total = sumDigit(num);
    string reversed_string = to_string(total);
    reverse(reversed_string.begin(),reversed_string.end());
    bool is_palindrome = (to_string(total) == reversed_string);
    if (is_palindrome)
    {
        cout << "Result " << to_string(total) << " is a palindrome" << endl;
        return true;
    }else{
        cout << "Result " << to_string(total) << " is not a palindrome" << endl;
        cout << recPal(total) <<endl;
        return false;
    }
    
}

int main(){
    fstream inFile;
    ofstream resultFile;
    inFile.open("data1.dat");
    resultFile.open("Result.txt");
    while (!inFile.eof())
    {
        int data = 0;
        inFile >>data;
        cout << data << ": ";
        bool is_palindrome = checkPal(data); 
        cout << endl;
        string result;
        if (is_palindrome){
            result = to_string(data) + " is a palindrome ." + recPal(sumDigit(data));
        }else{
            result = to_string(data) + " is not a palindrome.";
        }
        resultFile << result << endl;
    }
    inFile.close();
    resultFile.close();
}