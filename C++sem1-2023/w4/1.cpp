#include <iostream>
#include <string>

class ComplNum{
    double real;
    double imag;
public:
    ComplNum(double real, double imag){
        this->real = real;
        this->imag = imag;
    };
    ComplNum() = default;
    double getReal(){return real;};
    double getImag(){return imag;};
    friend ComplNum &operator-(ComplNum &num1, ComplNum &num2);
    friend ComplNum &operator-(ComplNum &num1, double num);
    friend ComplNum &operator-(double num, ComplNum &num1);
    friend ComplNum &operator--(ComplNum &num1);
    friend ComplNum &operator--(ComplNum &num1, int notUsed);
    double absoluteValue(ComplNum &num);
};

ComplNum &operator-(ComplNum &num1, ComplNum &num2){
    double real = num1.real - num2.real;
    double imag = num1.imag - num2.imag;
    ComplNum &newComp = ComplNum(real,imag);
    return newComp;
}

ComplNum &operator-(ComplNum &num1, double num){
    double real = num1.real - num;
    ComplNum &newComp = ComplNum(real,num1.imag);
    return newComp;
}

ComplNum &operator-(double num, ComplNum &num1){
    double real = num - num1.real;
    ComplNum &newComp = ComplNum(real,num1.imag);
    return newComp;
}

ComplNum &operator--(ComplNum &num1){
    num1.real--;
    num1.imag--;
    return num1;
}

ComplNum &operator--(ComplNum &num1, int notUsed){
    ComplNum temp = num1;
    temp.real--;
    temp.imag--;
    return temp;
}

double ComplNum::absoluteValue(ComplNum &num){
    return sqrt(num.real*num.real -num.imag*num.imag);
}