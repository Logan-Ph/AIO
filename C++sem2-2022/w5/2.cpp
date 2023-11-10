#include <vector>
#include "iostream"
#include "string"

using namespace std;

class Book{
private:
    string *name;
    int *price;
    int scores[3] = {0,0,0};
public:
    Book(string *name, int *price){
        this->name = name;
        this->price = price;
    }
    Book() = default;
    friend ostream &operator<<(ostream &os, const Book &book){
        return os << "name: " << book.name <<  ", price: " << book.price;
    }
    ~Book(){
        delete price;
        delete name;
    }

    const int *getScores() const {
        return scores;
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
//}