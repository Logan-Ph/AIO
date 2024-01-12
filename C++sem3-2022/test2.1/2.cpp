#include <iostream>
#include <string>

class Customer
{
public:
    std::string name;
    Customer *next;
    double bonus;
    double expenses;
    Customer(std::string _name = "", double _expenses = 0) : name{_name}, expenses{_expenses} {};
    void linkForward(Customer *cus)
    {
        this->next = cus;
    };
    friend std::ostream &operator<<(std::ostream &os, Customer *customer)
    {
        return os << customer->name << " (" << customer->expenses << ")";
    }
};

void printTransaction(Customer *head)
{
    Customer *temp = head;
    while (temp)
    {
        std::cout << temp;
        if (temp->next)
        {
            std::cout << " -> ";
        }
        temp = temp->next;
    }
    std::cout << std::endl;
}

void customerWithLargestExpenses(Customer *head)
{
    Customer *temp = head;
    Customer *largestExpensesCustomer = head;
    while (temp)
    {
        if (temp->expenses > largestExpensesCustomer->expenses)
        {
            largestExpensesCustomer = temp;
        }
        temp = temp->next;
    }
    std::cout << "Customer with largest expense: " << largestExpensesCustomer->name << std::endl;
}

void updateBonus(Customer *head)
{
    Customer *temp = head->next;
    double totalPriorExpense = 0;
    while (temp)
    {
        totalPriorExpense += temp->expenses;
        temp = temp->next;
    }
    temp = head;
    std::cout << "All bonuses: ";
    while (temp && temp->next)
    {
        temp->bonus = temp->next->expenses * 0.05 + (totalPriorExpense - temp->next->expenses) * 0.02;
        totalPriorExpense -= temp->next->expenses;
        std::cout << temp->name << ": " << temp->bonus << " ";
        temp = temp->next;
    }
    std::cout << std:: endl;
}

int main()
{
    Customer *Peter = new Customer("Pete", 1000);
    Customer *John = new Customer("John", 200);
    Customer *Harry = new Customer("Harry", 1200);
    Customer *Luna = new Customer("Luna", 400);
    Peter->linkForward(John);
    John->linkForward(Harry);
    Harry->linkForward(Luna);
    printTransaction(Peter);
    customerWithLargestExpenses(Peter);
    updateBonus(Peter);
}