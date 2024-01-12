#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Book;
class User;

class Book
{
    string title;
    int availableCopies;
    vector<string> namesOfBorrowers;

public:
    Book(string title = "", int availableCopies = 0, vector<string> namesOfBorrowers = vector<string>()) : title{title}, availableCopies{availableCopies}, namesOfBorrowers{namesOfBorrowers} {};
    friend class User;
};

class User
{
    string name;
    vector<Book *> borrowedBooks;

public:
    User(string name = "", vector<Book *> borrowedBooks = vector<Book *>()) : name{name}, borrowedBooks{borrowedBooks} {};
    bool doBorrow(Book &abook);
    void doReturn(Book &abook);
};

bool User::doBorrow(Book &abook)
{
    if (abook.availableCopies == 0)
    {
        cout << "There are no books to borrow" << endl;
        return false;
    }

    auto it = find(abook.namesOfBorrowers.begin(), abook.namesOfBorrowers.end(), name);
    if (it != abook.namesOfBorrowers.end())
    {
        cout << "You already borrowed this book" << endl;
        return false;
    }

    abook.availableCopies--;
    borrowedBooks.push_back(&abook);
    abook.namesOfBorrowers.push_back(name);
    cout << "Borrow book successfully" << endl;
    return true;
}

void User::doReturn(Book &abook)
{
    auto it = find_if(borrowedBooks.begin(), borrowedBooks.end(), [abook](Book *book){return abook.title == book->title;});
    if (it == borrowedBooks.end()){cout << "You did not borrow this book" << endl; return;}
    auto nameIt = find(abook.namesOfBorrowers.begin(), abook.namesOfBorrowers.end(), name);
    abook.namesOfBorrowers.erase(nameIt);
    borrowedBooks.erase(it);
    abook.availableCopies++;
    cout << "Return book successfully" << endl;
    return;
}

int main()
{
    Book b1("Book1", 2);
    Book b2("Book1", 1);
    Book b3("Book1", 3);

    User user1("user1");
    user1.doBorrow(b1);
    user1.doReturn(b1);
    user1.doReturn(b1);
}