#include <utility>
#include <vector>
#include <algorithm>
#include "iostream"
#include "string"

using namespace std;

class Book{
private:
    string name;
    int price;

public:
    Book(string name, int price) : name(std::move(name)), price(price) {}
    Book() = default;
    friend ostream &operator<<(ostream &os, const Book &book){
        return os << "name: " << book.name <<  ", price: " << book.price;
    }
    bool operator<(Book &book) const{
        return this->price > book.price;
    }
};

//int main(){
//    Book *book1,*book2,*book3;
//    book1 = new Book("Meow1",123123);
//    book2 = new Book("Meow2",133422);
//    book3 = new Book("Meow3",345342);
//
//    cout << *book1 << endl;
//    cout << *book2 << endl;
//    cout << *book3 << endl;
//
//    delete book1;
//    delete book2;
//    delete book3;
//
//    cout << *book1 << endl;
//    cout << *book2 << endl;
//    cout << *book3 << endl;

//    int n;
//    cout << "Enter the length of the array: " << endl;
//    cin >> n;
//    Book *book[n];
//    for (int i = 0; i<n ; i++){
//        string name;
//        int price;
//        cout << "Enter the name of the book: " << endl;
//        cin.ignore(sizeof(n),'\n');
//        getline(cin, name);
//        cout << "Enter the price of the book: " << endl;
//        cin >> price;
//        book[i] = new Book(name,price);
//    }
//    sort(book, book+n);
//    cout << *book[n-1] << endl;
//}