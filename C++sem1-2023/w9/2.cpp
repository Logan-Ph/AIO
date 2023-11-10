#include <iostream>
#include <string>

using namespace std;

const int MAX_FRIENDS = 5000;

class FaceBooker{
public:
    string name;
    FaceBooker(string name):name{name}{};    
    FaceBooker() = default;
};

class NetworkModel{
    int num=0;
    FaceBooker *arr = new FaceBooker[MAX_FRIENDS];
    NetworkModel(){
        for (size_t i = 0; i < MAX_FRIENDS; i++)
        {
            arr[i] = *new FaceBooker[MAX_FRIENDS];
        }
    };
};
