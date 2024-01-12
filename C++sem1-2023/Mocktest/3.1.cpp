#include <iostream>
#include <string>
#include <vector>

class Product
{
public:
    std::string name;
    double price;
    Product(std::string _name = "", double _price = 0.0) : name{_name}, price{_price} {};
};

class Shop
{
public:
    std::vector<Product> sellProducts;
    Shop(std::vector<Product> _sellProducts = std::vector<Product>()) : sellProducts{_sellProducts} {};
};

class Order
{
public:
    static int orderCount;
    int orderId;
    std::vector<Product> orderProducts;
    Order(std::vector<Product> _orderProducts = std::vector<Product>()) : orderId{orderCount++}, orderProducts{_orderProducts} {};
    void showInfo()
    {
        for (auto product : orderProducts)
        {
            std::cout << product.name << " " << product.price << std::endl;
        }
    }
};

int Order::orderCount = 0;

class Customer
{
public:
    bool isGoldAccount;
    std::string name;
    std::vector<Order> orders;
    Customer(bool _isGoldAccount, std::string name = "", std::vector<Order> _orders = std::vector<Order>()) : isGoldAccount{_isGoldAccount}, name{name}, orders{_orders} {};
    void getTotalExpenses()
    {
        for (auto order : orders)
        {
            order.showInfo();
            double total = 0;
            double discount = (isGoldAccount) ? 0.05 : 0;
            for (auto product : order.orderProducts)
            {
                total += product.price;
            }
            std::cout << "Total: " << total * (1 - discount) << std::endl;
        }
    };
};

int main(){
    Product p1 = Product("Iphone14", 423);
    Product p2 = Product("Mac pro", 134);
    Product p3 = Product("Ipad pro", 123);
    Product p4 = Product("Ipad min", 22);
    std::vector <Product> orderProducts = {p1, p2};
    std::vector<Product> products = {p1, p2, p3, p4};
    Shop shop = Shop(products);
    Order order = Order(orderProducts);
    std::vector<Order> ordersList = {order};
    Customer customer = Customer(true, "David", ordersList);
    Customer customer2 = Customer(false, "Nig", ordersList);
    customer.getTotalExpenses();
    customer2.getTotalExpenses();
}


