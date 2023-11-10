#include <vector>
#include <algorithm>
#include "iostream"
#include "string"

using namespace std;

class User;
class Book;
class SuperUser;

class User{
private:
    string name;

protected:
    vector<Book*> borrowedBooks;
public:
    explicit User(const string &name) : name(name) {}

    string getName() const{
        return name;
    }

    virtual bool doBorrow(Book &abook);
    bool doReturn(Book &abook);
};

class SuperUser: public User{
public:
    explicit SuperUser(const string &name);

private:
    bool doBorrow(Book &abook);
};


class Book{
private:
    string title;
    int availableCopies;
    vector<string> namesOfBorrowers;
public:
    Book(const string &title, int availableCopies) : title(title), availableCopies(availableCopies) {}

    bool addBorrowers(User *user){
        auto name = find(namesOfBorrowers.begin(),namesOfBorrowers.end(),user->getName());
        if (name != namesOfBorrowers.end() || availableCopies ==0){
            return false;
        }else{
            namesOfBorrowers.push_back(user->getName());
            availableCopies--;
            return true;
        }
    }

    bool addBorrowers(SuperUser *superUser){
        if (count(namesOfBorrowers.begin(),namesOfBorrowers.end(),superUser->getName())==2){
            return false;
        }else{
            namesOfBorrowers.push_back(superUser->getName());
            availableCopies--;
            return true;
        }
    }

    bool removeBorrowers(User *user){
        auto iter1 = find(namesOfBorrowers.begin(),namesOfBorrowers.end(),user->getName());
        if (iter1 == namesOfBorrowers.end()){
            return false;
        }else{
            namesOfBorrowers.erase(iter1);
            availableCopies++;
            return true;
        }
    }

    bool removeBorrowers(SuperUser *superUser){
        return removeBorrowers(superUser);
    }

};

bool User::doBorrow(Book &abook) {
    if (abook.addBorrowers(this)) {
        borrowedBooks.push_back(&abook);
        cout << "Borrowing book successfully!" << endl;
        return true;
    }else{
        cout << "This user has already borrowed this book!" << endl;
        return false;
    }
}

bool User::doReturn(Book &abook) {
    if (abook.removeBorrowers(this)){
        auto bookFound = find(borrowedBooks.begin(),borrowedBooks.end(),&abook);
        borrowedBooks.erase(bookFound);
        cout << "Returning book successfully!" << endl;
        return true;
    }else{
        cout << "The user did not borrow this book!" << endl;
        return false;
    }
}

bool SuperUser::doBorrow(Book &abook) {
    if (abook.addBorrowers(this)) {
        borrowedBooks.push_back(&abook);
        cout << "Borrowing book successfully!" << endl;
        return true;
    }else{
        cout << "This user has already borrowed this book!" << endl;
        return false;
    }
}

SuperUser::SuperUser(const string &name) : User(name) {}


int main(){
    Book* book1 = new Book("Book1",12);
    Book* book2 = new Book("Book2",12);
    Book* book3 = new Book("Book3",12);

    User* user1 = new User("User1");
    User* user2 = new SuperUser("User2");

    user1->doBorrow(*book1);
    user1->doBorrow(*book2);
    user1->doBorrow(*book3);

    user1->doReturn(*book1);
    user1->doReturn(*book1);

    user2->doBorrow(*book1);
    user2->doBorrow(*book1);
    user2->doBorrow(*book1);
    user2->doReturn(*book1);
    user2->doReturn(*book1);
    user2->doReturn(*book1);
}