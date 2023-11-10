#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

class Broker
{
public:
    string name;
    Broker *nextBuyer;
    double buyPrice;
    Broker(string const &name, double buyPrice, Broker *nextBuyer): name {name}, nextBuyer{nextBuyer}, buyPrice{buyPrice}{};
    Broker(string const &name, double buyPrice): name {name}, buyPrice{buyPrice}{};
    Broker()= default;
};

void printTransaction(Broker *broker){
    cout << broker->name << ": initially bought the house for $" << broker->buyPrice << endl;
    while (broker && broker->nextBuyer)
    {
        cout << broker->name << " ---> " << broker->nextBuyer->name << " : price = $" << broker->nextBuyer->buyPrice << endl;
        broker = broker->nextBuyer;
    }
}

void printLowestProfit(Broker *broker){
    double lowestProfit = 9999999;
    Broker *lowestProfitBroker = broker;
    while (broker && broker->nextBuyer)
    {
        double temp = broker->nextBuyer->buyPrice - broker->buyPrice;
        if (temp < lowestProfit){
            lowestProfit = temp;
            lowestProfitBroker = broker;
        }
        broker = broker->nextBuyer;
    }
    cout << "The broker with the lowest profit is: " << lowestProfitBroker->name << ", profit: $" << lowestProfit << endl;
}

int main(){
    Broker *David = new Broker("David",800);
    Broker *John = new Broker("John",1000);
    Broker *Peter  = new Broker("Peter ",1200);
    Broker *Luna = new Broker("Luna",1800);
    Broker *Sophia = new Broker("Sophia",3500);

    David->nextBuyer = John;
    John->nextBuyer= Peter;
    Peter->nextBuyer= Luna;
    Luna->nextBuyer=Sophia;

    printTransaction(David);
    printLowestProfit(David);
}