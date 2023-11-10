#include <vector>
#include "iostream"
#include "string"
#include "algorithm"
using namespace std;

class Cat{
public:
    string name;
    int age{};
    Cat()= default;
    Cat(string &name, int age) : name(name), age(age) {}
    friend ostream &operator<<(ostream &os, const Cat &cat) {
        return os << "name: " << cat.name << ", age: " << cat.age;
    }
};

class Person{
public:
    Cat cat;
    string name;
    Person() = default;
    Person(Cat &cat1,string &name): cat(cat1),name(name){}

    bool operator<(const Person &rhs) const {
        return rhs.cat.age < cat.age;
    }
    friend ostream &operator<<(ostream &os, const Person &person) {
        return os << "name: " << person.name << ", cat[ " << person.cat << "]";
    }
};

//int main(){
//    vector<Person> people{};
//    Cat cat1(*new string("Cat1"),12);
//    Cat cat2(*new string("Cat2"),23);
//    Cat cat3(*new string("Cat3"),14);
//    Cat cat4(*new string("Cat4"),7);
//    Cat cat5(*new string("Cat5"),10);
//    Cat cat6(*new string("Cat6"),11);
//    Person person1{cat1,*new string ("person1")};
//    Person person2{cat2,*new string ("person2")};
//    Person person3{cat3,*new string ("person3")};
//    Person person4{cat4,*new string ("person4")};
//    Person person5{cat5,*new string ("person5")};
//    Person person6{cat6,*new string ("person6")};
//
//    people.push_back(person1);
//    people.push_back(person4);
//    people.push_back(person5);
//    people.push_back(person6);
//    people.push_back(person2);
//    people.push_back(person3);
//
//    sort(people.begin(),people.end());
//    cout << people.at(0)<<endl;
//}