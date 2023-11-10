#include <iostream>
#include <string>

using namespace std;

class TwoDShape{
private:
    float width, height;
public:
    void showDim(){
        cout<<"Width = " <<width<<", Height = "<<height<<endl;
    }

    void setW(float w){
        width = w;
    }

    void setH(float h){
        height = h;
    }

    float getW(){
        return width;
    }

    float getH(){
        return height;
    }
};

class Triangle: public TwoDShape{
public:
    char style[20];
    float area(){return getW()*getH()/2.0;}
};





int main(){
    Triangle ob1;
    ob1.setH(10);
    ob1.setW(2);
    cout << ob1.area() << endl;
}