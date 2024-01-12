#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <unordered_map>

class Product;
class Customer;
class Shop;
class Bill;

class Product
{
public:
    std::string name;
    int id;
    double price;
    Product(std::string _name = "", int _id = 0, double _price = 0) : name{_name}, id{_id}, price{_price} {};
};

class Bill
{
public:
    int id;
    std::vector<Product> products;
    Bill(int _id = 0, std::vector<Product> _products = std::vector<Product>()) : id{_id}, products{_products} {};
    double getTotalPrice()
    {
        double totalPrice = 0;
        for (Product product : products)
        {
            totalPrice += product.price;
        }
        return totalPrice;
    };
    friend std::ostream &operator<<(std::ostream &os, Bill bill)
    {
        os << "Bill " << bill.id << ": " << std::endl;
        std::cout << "Products: " << std::endl;
        for (Product product : bill.products)
        {
            os << "\t" << product.name << std::endl;
        }
        os << "Total price: " << bill.getTotalPrice();
        return os;
    }
};

class Customer
{
public:
    std::string name;
    int id;
    Bill lastBill;
    double totalSpentAmount;
    Customer(std::string name = "", int id = 0) : name{name}, id{id} {};
    void addBill(Bill bill)
    {
        totalSpentAmount += bill.getTotalPrice();
        lastBill = bill;
    }
};

class Shop
{
public:
    std::string name;
    std::vector<Product> products;
    std::vector<Bill> bills;
    std::vector<Customer> customers;
    Shop(std::string name = "", std::vector<Product> products = std::vector<Product>(), std::vector<Customer> customers = std::vector<Customer>()) : name{name}, products{products}, customers{customers} {};
    void getRevenue()
    {
        double revenue;
        for (Customer cus : customers)
        {
            revenue += cus.totalSpentAmount;
        }
        std::cout << "Revenue: " << revenue << std::endl;
    };
    void addProduct(Product product)
    {
        products.push_back(product);
    };
    void addNewCustomer(std::string name, int id)
    {
        Customer customer(name, id);
        customers.push_back(customer);
    };
    void printBill(int customerId, std::vector<int> productIds)
    {
        auto it = std::find_if(customers.begin(), customers.end(), [customerId](Customer &cus)
                               { return cus.id == customerId; });
        if (it == customers.end())
        {
            std::cout << "The customer does not exist" << std::endl;
        }
        std::vector<Product> productList;
        for (int productId : productIds)
        {
            auto its = std::find_if(products.begin(), products.end(), [productId](Product &pd)
                                    { return pd.id == productId; });
            if (its == products.end())
            {
                std::cout << "The product does not exist" << std::endl;
            }
            productList.push_back(*its);
        }
        Bill bill = Bill(0, productList);
        std::cout << bill << std::endl;
    };
};

int main()
{
    Product pd1 = Product("pd1", 0, 12);
    Product pd2 = Product("pd2", 1, 13);
    Product pd3 = Product("pd3", 2, 23);
    Product pd4 = Product("pd4", 3, 21);

    Customer cus1 = Customer("cus1", 0);
    Customer cus2 = Customer("cus2", 1);

    Bill bill1 = Bill(0, {pd1});
    Bill bill2 = Bill(1, {pd2, pd3});
    Bill bill3 = Bill(2, {pd2, pd3, pd4});

    cus1.addBill(bill1);
    cus1.addBill(bill2);

    cus2.addBill(bill3);

    Shop shop = Shop("Shop", {pd1, pd2, pd3, pd4}, {cus1, cus2});
    shop.getRevenue();
    shop.printBill(0,{0,1,2,3});
}