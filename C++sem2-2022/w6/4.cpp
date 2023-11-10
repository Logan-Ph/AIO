#include "iostream"
using namespace std;

class Book{
private:
    string *name;
    int *price;

public:
    Book(string *name, int *price){
        this->name = name;
        this->price = price;
    }
    Book() = default;
    Book(const Book &rhs): name( new string(*rhs.name)),price(new int(*rhs.price)){}
    friend ostream &operator<<(ostream &os, const Book &book){
        return os << "name: " << book.name <<  ", price: " << book.price;
    }

    Book &operator=(const Book &rhs){
        this->name = rhs.name;
        this->price = rhs.price;
    };

    ~Book(){
        delete price;
        delete name;
    }
};