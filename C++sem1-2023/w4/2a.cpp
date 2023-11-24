#include <iostream>
#include <string>
#include <fstream>

using namespace std;

class BankAcc
{
public:
    string name;
    float amount;
    BankAcc() = default;
    BankAcc(string name = "", float amount = 0) : name{name}, amount{amount} {};
    bool widthDraw(float num);
    friend ostream &operator<<(ostream &os, BankAcc &acc);
};

bool BankAcc::widthDraw(float num)
{
    if (num > amount)
    {
        cout << "Not enough money" << endl;
        return false;
    }
    amount -= num;
    return true;
}

ostream &operator<<(ostream &os, BankAcc &acc)
{
    return os << "Bank account[ name=" << acc.name << ", amount=" << acc.amount << "]" << endl;
}


int main(int argc, char const *argv[])
{
    BankAcc acc1("Sang", 1000);
    BankAcc acc2("Mary", 2000);
    if (argc >0){
        string fileName = argv[1];
        fstream myFile(fileName,ios::out);
        if (myFile.is_open()){
            myFile << acc1;
            myFile << acc2;
            myFile.close();
        }
        
    }
}
