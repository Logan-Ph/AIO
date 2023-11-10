#include "iostream"
#include "iomanip"
#include "string"
using namespace std;


int doubleVal(int num){
    return 2*num;
}

int doubleVal(string hexStr){
    int num = 2 * stoi(hexStr, nullptr, 16);
    return num;
}

double doubleVal(double num){
    return 2*num;
}

int main(){
    string input;
    getline(cin, input);

    if(input.find('.') != string::npos) {
        double num = stod(input);
        cout << fixed << setprecision(2) << doubleVal(num) << "\n";
    } else if(input.find("0x") != string::npos) {
        cout << "0x" << hex << doubleVal(input) << "\n";
    } else {
        int num = stoi(input);
        cout << doubleVal(num) << endl;
    }
}