#include <iostream>
#include <string>
#include <vector>
#include <utility>
#include <set>

using namespace std;
class User;
class EWallet;

class EWallet{
public:
    string name;
    double balance;
    EWallet() = default;
    EWallet(string aname, double balance): name{aname},  balance{balance}{};
    bool pay(double amount, string coupon);
    friend void operator>>(double number, EWallet &ewallet);
};

class User{
public:
    string name;
    string pwd;
    EWallet &acc;
    User() = default;
    User(string aname, string apwd, EWallet &aewallet): name{aname}, pwd{apwd}, acc{aewallet}{};
    bool verifyPass(string pass);
    bool doPayment(string pass);
};

bool User::verifyPass(string pass){
    return (pass == pwd) ? true:false;
}

bool User::doPayment(string pass){
    if (verifyPass(pass)){
        int amount;
        string coupon;
        cout << "Enter the amount of money: ";
        cin >> amount;
        cin.ignore(sizeof(amount),'\n');
        cout << "Enter the coupon to discount: ";
        getline(cin,coupon);
        if (acc.pay(amount,coupon)){
            return true;
        }else{
            return false;
        }
    }else{
        cerr << "Wrong password" <<endl;
        return false;
    }
}

bool EWallet::pay(double amount, string coupon){
    if (coupon == "BLACKFRIDAY"){
        amount = amount*0.7;
    }

    if (amount<= balance){
        balance-=amount;
        return true;
    }else{
        cerr << "Not enough money!" << endl;
        return false;
    }
}

void operator>>(double number, EWallet &ewallet){
    cout << "Increase the ballance by " << number << endl;
    ewallet.balance+=number;
    cout << "The balance after increased " << ewallet.balance << endl;
}



int main(){
    EWallet ewallet1 = EWallet("ewallet1",100);
    EWallet ewallet2 = EWallet("ewallet2",200);
    EWallet ewallet3 = EWallet("ewallet3",300);
    EWallet ewallet4 = EWallet("ewallet4",400);

    User *user1 = new User("user1","user1",ewallet1);
    User *user2 =new User("user2","user2",ewallet2);
    User *user3 =new User("user3","user3",ewallet3);
    User *user4 =new User("user4","user4",ewallet4);
    User *users[] = {user3,user2,user1,user4};

    set<pair<string,double>> pairs;
    for (int i=0; i<4;i++){
        pair<string,double> myPair(users[i]->name, users[i]->acc.balance);
        pairs.insert(myPair);  
    }

    pairs.erase(pairs.begin());
    auto myPair = *pairs.begin();
    cout << myPair.first << " - " << myPair.second <<endl;
}

