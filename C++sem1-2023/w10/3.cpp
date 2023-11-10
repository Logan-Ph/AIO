#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

template<typename type>
class vector_{
    vector<type> vec = vector<type>();
public:
    vector_() = default;
    void insert(type a);
    void remove(type a);
    bool findd(type a);
};

template<typename type>
void vector_<type>::insert(type a){
    vec.push_back(a);
}

template<typename type>
void vector_<type>::remove(type a){
    auto found = find(vec.begin(),vec.end(),a);
    if (found!= vec.end()){vec.erase(found);};
}

template<typename type>
bool vector_<type>::findd(type a){
    auto found = find(vec.begin(),vec.end(),a);
    return (found != vec.end())? true:false;
}

int main(){
    vector_<string> vec;
    vec.insert("Hi");
    vec.remove("Hi");
    cout << vec.findd("Hi") << endl;
}