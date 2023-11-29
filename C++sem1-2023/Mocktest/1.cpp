#include <iostream>
#include <string>
#include <iomanip>
#include <sstream>

using namespace std;

int doubleVal(int num)
{
    return num * 2;
}

double doubleVal(double num)
{
    return num * 2;
}

int doubleVal(string hexStr)
{
    int num;
    stringstream ss;
    ss << hex << hexStr;  // convert the string into hex number 
    ss >> num;
    cout << num << endl;
    return num*2;
}

int main(int argc, char const *argv[])
{
    if (argc != 2)
    {
        cout << "Please provide 1 argument" << endl;
        return 1;
    }

    string arg = argv[1];
    if (arg.find('.') != string::npos) //check if the number is double or float
    {
        double num = stod(arg);
        cout << setprecision(2) << fixed <<doubleVal(num) << endl;
    }
    else if (arg.find("0x") != string::npos || arg.find("0X") != string::npos) // check if the number is in the hexa type 
    {
        cout << showbase << hex << doubleVal(arg) << endl; // conver the hexa num back into
    }
    else
    {
        int num = stoi(arg);
        cout << showbase << doubleVal(num) << endl;
    }

    return 0;
}
