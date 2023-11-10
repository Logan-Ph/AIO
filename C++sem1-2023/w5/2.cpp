#include <iostream>
#include <string>

using namespace std;

class Book{
    string *name;
    int *price;
public:
    Book(string name, int price):name{new string(name)},price{new int(price)}{};
    Book() = default;
    ~Book() = default;
    friend ostream &operator<<(ostream &os, Book &book);
    int getPrice();
    string getName();
};


ostream &operator<<(ostream &os, Book &book){
    return os << "name = " << book.getName() << ", price = " << book.getPrice() << endl;
}

int Book::getPrice(){
    return *price;
}

string Book::getName(){
    return *name;
}

int main(){
    Book *b1 = new Book("b1",12);
    Book *b2 = new Book("b2",13);
    Book *b3 = new Book("b3",42);
    Book *b4 = new Book("b4",23);

    Book **books = new Book*[4] {b1,b2,b3,b4};
    for (int i=0; i<4;i++){
        cout << *books[i];
        delete books[i];
        books[i] = nullptr;
    }
}