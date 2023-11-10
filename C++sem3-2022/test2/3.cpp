#include <iostream>
#include <string>
#include <vector>
#include <memory>
#include <utility>
#include <algorithm>

using namespace std;

class Shop;
class Product;
class Customer;
class Bill;

class Shop
{
private:
    string name;
    vector<Product> *products = new vector<Product>();
    double revenue;

public:
    vector<Customer> *customers = new vector<Customer>();
    Shop() = default;
    Shop(string name, vector<Product> *products) : name{name}, products{products} {};
    bool addProduct(string name, int id, double price);
    bool addCustomer(string name, int id);
    double calculateBill(int cusId, vector<int> prodID);
};

class Product
{
public:
    string name;
    int id;
    double price;
    Product() = default;
    Product(string name, int id, double price) : name{name}, id{id}, price{price} {};
    int getId() { return id; };
};

class Bill{
public:
    double total;
    vector<Product> *products = new vector<Product>();
    Bill(double atotal,vector<Product> *aproducts){
        products = aproducts;
        total = atotal;
    };
};

class Customer
{
public:
    string name;
    int id;
    Bill *lastBill;
    vector<Bill> *bills = new vector<Bill>();
    double spentAmount;
    Customer() = default;
    Customer(string name, int id) : name{name}, id{id} {};
    bool addBill(Bill *bill)
    {
        bills->push_back(*bill);
        return true;
    };
};

bool Shop::addProduct(string name, int id, double price)
{
    auto found = find_if(products->begin(), products->end(), [id](Product prd)
                         {return prd.getId() == id; });
    if (found != products->end())
    {
        cout << "The product already existed in the selling list" << endl;
        return false;
    }
    else
    {
        unique_ptr<Product> product = make_unique<Product>(name, id, price);
        products->push_back(*product);
        return true;
    }
};

bool Shop::addCustomer(string name, int id)
{
    auto found = find_if(customers->begin(), customers->end(), [id](Customer cus) { return cus.id == id; });
    if (found != customers->end())
    {
        cout << "The customer already existed" << endl;
        return false;
    }
    else
    {
        Customer *customer = new Customer(name,id);
        customers->push_back(*customer);
        return true;
    }
};

double Shop::calculateBill(int cusId, vector<int> prodID){
    auto it = find_if(customers->begin(), customers->end(), [cusId](Customer cus){return cus.id == cusId;});
    if (it == customers->end()){
        cout << "The customer does not exist" << endl;
        return 0;
    }else{
        Customer cus = *it;
        vector<Product> *prs = new vector<Product>();
        double total = 0;
        for (int id: prodID){
            auto prd = find_if(products->begin(), products->end(), [id](Product p){return p.id == id;});
            if (prd!= products->end()){
                Product pr = *prd;
                total+= pr.price;
                prs->push_back(pr);
            }
        }
        Bill *bill = new Bill(total,prs);
        cus.addBill(bill);
        cus.lastBill = bill;
        return total;
    }
}

int main(){
    Product *p1 = new Product("p1",1,123);
    Product *p2 = new Product("p2",2,12);
    Product *p3 = new Product("p3",3,134);
    Product *p4 = new Product("p4",4,345);
    vector<Product> *products = new vector<Product>();
    products->push_back(*p1);
    products->push_back(*p2);
    products->push_back(*p3);
    products->push_back(*p4);

    Shop *shop = new Shop("shop1",products);
    shop->addCustomer("cus1",12);

    vector<int> *prdID = new vector<int>();
    prdID->push_back(1);
    prdID->push_back(2);
    prdID->push_back(3);

    cout << shop->calculateBill(12,*prdID) << endl;
}