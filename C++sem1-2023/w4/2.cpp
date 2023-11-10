#include <iostream>
#include <string>
#include <fstream>

using namespace std;

class BankAcc{
    string name;
    float amount;
public:
    BankAcc(string name, float amount): name{name}, amount{amount}{};
    BankAcc() = default;
    bool withdraw(float num);
    string getName(){return name;};
    float getAmount(){return amount;};
    friend ostream &operator<<(ostream &os, BankAcc &acc);
};

bool BankAcc::withdraw(float num){
    if (num > amount){
        cout << "Insufficient Balance"<<endl;
        return false;
    }else{
        amount -= num;
        cout << "Withdraw successfully";
        return true;
    }
}

ostream &operator<<(ostream &os, BankAcc &acc){
    return os << "name = " << acc.getName() << ", amount = " << acc.getAmount() << endl;
}

void saveData(BankAcc &bankAcc, string fileName){
    fstream myFile(fileName, ios::app);
    myFile << "name = " << bankAcc.getName()<< ", amount = " <<bankAcc.getAmount() << endl;
    myFile.close();
}

int main(int argc, char const *argv[])
{
    if (!argv[1]){
        BankAcc acc1 = BankAcc("acc1",12);
        BankAcc acc2 = BankAcc("acc2",23);
        BankAcc acc3 = BankAcc("acc3",14);
        cout << acc1;
        cout << acc2;
        cout << acc3;
    }else{
        BankAcc acc1 = BankAcc("acc1",12);
        BankAcc acc2 = BankAcc("acc2",23);
        BankAcc acc3 = BankAcc("acc3",14);
        saveData(acc1,argv[1]);
        saveData(acc2,argv[1]);
        saveData(acc3,argv[1]);
    }
}

