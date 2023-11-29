#include <iostream>
#include <string>
#define ARRAY_SIZE 3
#include <memory>
#include <array>
#include <algorithm>

using namespace std;

class Book
{
    string *name;
    int price;

public:
    Book(string name = "", int price = 0) : name{new string(name)}, price{price} {};
    ~Book() = default;
    friend ostream &operator<<(ostream &os,const Book &book);
    friend istream &operator>>(istream &is, Book &book);
    friend bool operator>(const Book &b1, const Book &b2);
};

bool operator>(const Book &b1, const Book &b2)
{
    return b1.price > b2.price;
}

istream &operator>>(istream &is, Book &book)
{
    cout << "Enter the name of the book: ";
    getline(is, *(book.name));
    cout << "Enter the price of the book: ";
    is >> book.price;
    is.ignore(1, '\n');
    return is;
}

ostream &operator<<(ostream &os, const Book &book)
{
    return os << "[name: " << *(book.name) << ", price: " << book.price << "]" << endl;
}

Book MostExpensiveBook(Book *books, int arraySize)
{
    sort(books, books + arraySize, greater<Book>());
    return *books;
}

int main()
{
    int arraySize;
    cout << "Enter the number of books: ";
    cin >> arraySize;
    cin.ignore(1, '\n');
    Book *books = new Book[arraySize];
    for (int i = 0; i < arraySize; i++)
    {
        Book book;
        cin >> book;
        books[i] = book;
    }
    cout << MostExpensiveBook(books, arraySize);
}