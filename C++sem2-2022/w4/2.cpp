#include <utility>
#include "iostream"
#include <vector>
#include <fstream>

using namespace std;

class BankAcc{
public:
    string name;
    float amount{};

    BankAcc(string name, float amount) : name(std::move(name)), amount(amount) {}
    BankAcc() = default;

    friend ostream &operator<<(ostream &os, BankAcc &BankAcc){
        return os << "name: " <<BankAcc.name << ", amount: " << BankAcc.amount << endl;
    }

    bool withdraw(float num){
        if (this->amount >= num){
            this -> amount -= num;
            return true;
        }else{
            cerr << "Cannot withdraw with the current balance";
            return false;
        }
    }
};

bool saveData(const vector<BankAcc>& bankAccs){
    string fileName;
    cout << "Please enter the file name to save" << endl;
    getline(cin,fileName);
    if (fileName.empty()){
        cerr << "The file name is empty!" << endl;
        return false;
    }else{
        fstream file;
        file.open(fileName, ios::out);
        for (BankAcc bankAcc:bankAccs){
            file << bankAcc;
        }
        cout << "Writing password to file successfully";
        file.close();
        return true;
    }
}


//int main(){
//    BankAcc bankAcc1("acc1",12000),bankAcc2("acc2",23000);
//    vector<BankAcc> acc;
//    acc.push_back(bankAcc1);
//    acc.push_back(bankAcc2);
//    saveData(acc);
//}