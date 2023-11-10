#include <iostream>
#include <string>
#include <numeric>
#include <algorithm>
#include <vector>

using namespace std;

class Product;
class Shop;
class Customer;
class Order;
class NormalCustomer;
class GoldCustomer;

class Shop
{
    vector<Product> *products;
    string name;

public:
    Shop(string name) : name{name} {};
    bool addProduct(Product *product);
    bool removeProduct(Product *product);
    vector<Product> *getProducts();
};

class Product
{
    string name;
    double price;

public:
    Product(string &name, double price) : name{name}, price{price} {};
    string getName() const;
    double getPrice() const;
};

double Product::getPrice() const
{
    return price;
}

string Product::getName() const
{
    return name;
}

class Customer
{
    string name;
    vector<Order> *orders;

public:
    explicit Customer(string &name) : name{name} {};
    bool placeOrder(vector<Product> *products);
    bool returnProduct();
    virtual double getTotalExpenses();
};

class Order
{
    static int id;
    vector<Product> *products;

public:
    explicit Order()
    {
        id = ++Order::id;
    };
    explicit Order(vector<Product> *aproducts)
    {
        id = ++Order::id;
        products = aproducts;
    };
    int getId();
    vector<Product> *getProducts();
    double getTotalExpenses();
    bool removeProduct(Product *product);
    bool removeProduct(string &productName);

};

class NormalCustomer : public Customer
{
public:
    explicit NormalCustomer(string &name) : Customer(name){};
};

class GoldCustomer : public Customer
{
    double discount = 0.05;

public:
    explicit GoldCustomer(string &name) : Customer(name){};
    double getTotalExpenses();
};

vector<Product> *Order::getProducts()
{
    return products;
}

bool Customer::returnProduct()
{
    cout << "Orders: " << endl;
    for (Order order : *orders)
    {
        cout << "id: " <<order.getId() << endl;
    }
    cout << "Please enter the order id: " << endl;
    int id;
    cin>> id;
    cin.ignore(sizeof(id),'\n');
    auto foundOrder = find(orders->begin(),orders->end(), [&](Order order){return order.getId() == id;});
    if (foundOrder != orders->end()){
        vector<Product> *prods = ((Order) *foundOrder).getProducts();
        for (Product pr: *prods){
            cout << "name: " <<pr.getName() << ",price: $" <<pr.getPrice() << endl;
        }
        string productName;
        cout << "Enter the name of the product: ";
        getline(cin,productName);
        if (((Order) *foundOrder).removeProduct(productName)){
            cout << "Remove product successfully" << endl;
            return true;
        }
    }else{
        cout << "The order does not exist!" << endl;
        return false;
    }
}

bool Customer::placeOrder(vector<Product> *products)
{
    vector<Product> *listOfProducts;
    while (true)
    {
        int i = 0;
        for (Product product : *products)
        {
            cout << ++i << ": " << product.getName() << endl;
        }
        cout << "Please enter the name of the product: ";
        string productName;
        getline(cin, productName);
        auto found = find_if(products->begin(), products->end(), [&](Product prd)
                             { return prd.getName() == productName; });

        auto currentExist = find_if(listOfProducts->begin(), listOfProducts->end(), [&](Product prd)
                                    { return prd.getName() == productName; });

        auto pasExist = find_if(orders->begin(), orders->end(), [&](Order order)
                                {
            auto existedProduct = find_if(order.getProducts()->begin(),order.getProducts()->end(), [&](Product pr){pr.getName() == productName;});
            return (existedProduct != order.getProducts()->end())? true: false; });

        if (currentExist != listOfProducts->end())
        {
            cout << "The product already existed!" << endl;
        }
        else if (pasExist != orders->end())
        {
            cout << "The product already existed in the past order!" << endl;
        }
        else if (found != products->end())
        {
            listOfProducts->push_back(*found);
        }
        else
        {
            cout << "Can not find the product!" << endl;
        }

        cout << "Enter x to exit or else to continue: " << endl;
        char choice;
        cin >> choice;
        cin.ignore(sizeof(choice), '\n');
        if (tolower(choice) == 'x')
            break;
    }
    Order *order = new Order(listOfProducts);
    orders->push_back(*order);
    delete listOfProducts;
    listOfProducts = nullptr;
    delete order;
    order = nullptr;
    return true;
}

vector<Product> *Shop::getProducts()
{
    return products;
};

double GoldCustomer::getTotalExpenses()
{
    return Customer::getTotalExpenses() * 0.95;
}

double Customer::getTotalExpenses()
{
    double sum = 0.0;
    for (Order order : *orders)
    {
        sum += order.getTotalExpenses();
    }
    return sum;
}

double Order::getTotalExpenses()
{
    double sum = 0.0;
    for (Product product : *products)
    {
        sum += product.getPrice();
    }
    return sum;
}

int Order::getId()
{
    return id;
}

bool Shop::addProduct(Product *product)
{
    auto found = find(products->begin(), products->end(), product->getName());
    if (found == products->end())
    {
        return false;
    }
    else
    {
        products->push_back(*product);
        return true;
    }
}

bool Shop::removeProduct(Product *product)
{
    auto found = find(products->begin(), products->end(), product->getName());
    if (found == products->end())
    {
        return false;
    }
    else
    {
        products->erase(found);
        return true;
    }
}

bool Order::removeProduct(Product *product)
{
    auto found = find_if(products->begin(), products->end(), product->getName());
    if (found == products->end())
    {
        return false;
    }
    else
    {
        products->erase(found);
        return true;
    }
}

bool Order::removeProduct(string &productName)
{
    auto found = find_if(products->begin(), products->end(), [&](Product prod){prod.getName() == productName;});
     if (found == products->end())
    {
        return false;
    }
    else
    {
        products->erase(found);
        return true;
    }
}

int main(){
    Shop *shop = new Shop("Shop1");
    int choice = 0;
}