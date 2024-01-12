#include <iostream>
#include <string>

using namespace std;

class Customer
{
public:
    string name;
    int expenses;
    double bonus;
    Customer *next;
    Customer() = default;
    Customer(string name, int expenses) : name{name}, expenses{expenses} {};
    friend ostream &operator<<(ostream &os, Customer *head)
    {
        while (head != nullptr)
        {
            if (head->next != nullptr)
            {
                os << head->name << " (" << head->expenses << ")"
                   << " -> ";
            }
            else
            {
                os << head->name << " (" << head->expenses << ")";
            }
            head = head->next;
        }
        return os;
    };
};

Customer *largestExpensesCustomer(Customer *head)
{
    Customer *temp = head;
    while (head)
    {
        if (head->expenses > temp->expenses)
        {
            temp = head;
        }

        head = head->next;
    }

    return temp;
}

// O(n)
void updateBonus(Customer *head)
{
    Customer *ptr = head;
    double totalExpenses = 0;
    while (ptr)
    {
        totalExpenses += ptr->expenses;
        ptr = ptr->next;
    }

    Customer *temp = head;
    totalExpenses -= temp->expenses;
    std::cout << "All bonus: ";
    while (temp && temp->next)
    {
        temp->bonus = (totalExpenses - temp->next->expenses)*0.02 + temp->next->expenses*0.05;
        std::cout << temp->name << ": " << temp->bonus << " ";
        totalExpenses -= temp->next->expenses;
        temp = temp->next;
    }
}

int main()
{
    Customer *cus1 = new Customer("Peter", 1000);
    Customer *cus2 = new Customer("John", 200);
    Customer *cus3 = new Customer("Harry", 1200);
    Customer *cus4 = new Customer("Luna", 400);

    cus1->next = cus2;
    cus2->next = cus3;
    cus3->next = cus4;

    cout << cus1 << endl;

    Customer *temp = largestExpensesCustomer(cus1);
    cout << "Customer with the largest expense: " << temp->name << endl;
    updateBonus(cus1);
}
