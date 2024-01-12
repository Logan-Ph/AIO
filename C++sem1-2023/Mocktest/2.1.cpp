#include <iostream>
#include <string>

class Broker
{
public:
    std::string name;
    double buyPrice;
    Broker *nextBuyer;
    Broker(std::string _name, double _buyPrice, Broker *_nextBuyer = nullptr) : name{_name}, buyPrice{_buyPrice}, nextBuyer{_nextBuyer} {};
};

void printTransaction(Broker *head)
{
    Broker *temp = head;
    std::cout << temp->name << ": bought the house for $" << temp->buyPrice << std::endl;
    while (temp && temp->nextBuyer)
    {
        std::cout << temp->name << " --> " << temp->nextBuyer->name << ": price = $" << temp->nextBuyer->buyPrice << std::endl;
        temp = temp->nextBuyer;
    }
}

void getBrokerMinProfit(Broker *head)
{
    Broker *temp = head;
    Broker *minProfitBroker = head;
    while (temp && temp->nextBuyer)
    {
        if (temp->nextBuyer->buyPrice - temp->buyPrice < minProfitBroker->nextBuyer->buyPrice - minProfitBroker->buyPrice)
        {
            minProfitBroker = temp;
        }
        temp = temp->nextBuyer;
    }
    std::cout << "Broker with minimum profit: " << minProfitBroker->name << std::endl;
    std::cout << "Profit: $" << minProfitBroker->nextBuyer->buyPrice - minProfitBroker->buyPrice << std::endl;
}

int main()
{
    Broker *David = new Broker("David", 800);
    Broker *John = new Broker("John", 1000);
    Broker *Peter = new Broker("Peter ", 1200);
    Broker *Luna = new Broker("Luna", 1800);
    Broker *Shopia = new Broker("Shopia", 3500);
    David->nextBuyer = John;
    John->nextBuyer = Peter;
    Peter->nextBuyer = Luna;
    Luna->nextBuyer = Shopia;
    printTransaction(David);
    getBrokerMinProfit(David);
}