#include <iostream>
#include <string>

using namespace std;

class Cat{
public:
    int age{};
    string name;

    Cat(int age, const string &name) : age(age), name(name) {}
    friend ostream& operator<<(ostream &os, const Cat &cat){
        return os << cat.name << " " << cat.age << endl;
    }
};

int main(){
    Cat cat1(12,"Meow1");
    Cat cat2(23,"Meow2");
    cout << cat1<< endl;
    cout << cat2 << endl;

    cat2 = cat1;
    cout << &cat2<< endl;
    cout << &cat1<< endl;
    cout << cat1<< endl;
    cout << cat2 << endl;
}
