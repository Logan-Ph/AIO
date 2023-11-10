#include <valarray>
#include "iostream"
using namespace std;

class ComplNum{
private:
    double real,imag;
public:
    ComplNum() {}

    ComplNum(double real, double imag){
        this->imag = imag;
        this->real = real;
    }

    friend double abs(ComplNum &complNum){

        return sqrt(complNum.real*complNum.real+complNum.imag*complNum.imag);
    }


    friend ostream &operator<<(ostream &os, ComplNum &complNum){
        if(complNum.real == 0){
            return os << showpos << complNum.imag << "i" << endl;
        }else{
            return os << complNum.real << showpos << complNum.imag << "i" << endl;
        }
    }

    friend ComplNum operator-(double num, ComplNum &complNum){
        complNum.real = num-complNum.real;
        complNum.imag = -complNum.imag;
        return complNum;
    }

    friend ComplNum operator-(ComplNum &complNum, double num){
        complNum.real = complNum.real-num;
        return complNum;
    }

    friend ComplNum operator-(ComplNum &complNum1,ComplNum &complNum2){
        ComplNum complNum(complNum1.real-complNum2.real,complNum1.imag-complNum2.imag);
        return complNum;
    }

    friend ComplNum operator--(ComplNum &complNum1,int notused){
        ComplNum temp = complNum1;
        --complNum1.real;
        --complNum1.imag;
        return temp;
    }

    friend ComplNum operator--(ComplNum &complNum1){
        --complNum1.real;
        --complNum1.imag;
        return complNum1;
    }
};

//int main(){
//    ComplNum num1(12,3);
//    ComplNum num2(3,12);
//    num2 = num1--;
//    cout << abs(num2);
//}