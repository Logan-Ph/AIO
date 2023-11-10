#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Book
{
    string name;
    int availableCopies;
    vector<string> *namesOfBorrowers = new vector<string>();

public:
    Book(string name, int availableCopies) : name{name}, availableCopies{availableCopies} {};
    vector<string> *getNamesOfBorrowers();
    string getName();
    int getAvailableCopies();
    bool setAvailableCopies(int num);
};

vector<string> *Book::getNamesOfBorrowers()
{
    return namesOfBorrowers;
}

string Book::getName()
{
    return name;
}

int Book::getAvailableCopies()
{
    return availableCopies;
}

bool Book::setAvailableCopies(int num)
{
    if (availableCopies == 0)
    {
        cout << "Not enough available copies" << endl;
        return false;
    }
    else
    {
        availableCopies += num;
        return true;
    }
}

class User
{
    string name;
    vector<Book *> *borrowedBooks = new vector<Book *>();

public:
    User(string name) : name{name} {};
    bool doBorrow(Book &abook);
    bool doReturn(Book &abook);
};

bool User::doBorrow(Book &abook)
{

    if (abook.setAvailableCopies(-1))
    {
        auto found = find_if(borrowedBooks->begin(), borrowedBooks->end(), [&abook](Book *book)
                             { return book->getName() == abook.getName(); });
        if (found == borrowedBooks->end())
        {
            borrowedBooks->push_back(&abook);
            abook.getNamesOfBorrowers()->push_back(name);
            cout << "Borrow book successfully" << endl;
            return true;
        }else{
            cout << "This user already borrowed this book" << endl;
        }
    }
    cout << "Borrow book unsuccessfully" << endl;
    return false;
}

bool User::doReturn(Book &abook)
{
    auto found = find_if(borrowedBooks->begin(), borrowedBooks->end(), [&abook](Book *book)
                         { return book->getName() == abook.getName(); });
    if (found != borrowedBooks->end())
    {
        borrowedBooks->erase(found);
        cout << "Return book succesfully!" << endl;
        return true;
    }
    else
    {
        cout << "Return book unsuccesfully!" << endl;
        return false;
    }
}

int main()
{
    Book *b1 = new Book("b1", 13);
    Book *b2 = new Book("b2", 12);
    Book *b3 = new Book("b3", 4);

    User *user1 = new User("User1");
    user1->doBorrow(*b1);
    user1->doBorrow(*b1);
}