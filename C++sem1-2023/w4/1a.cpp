#include <iostream>
#include <iomanip>
#include <math.h>

using namespace std;

class ComplNum
{
private:
    double real;
    double imag;

public:
    ComplNum() = default;
    ComplNum(double real = 0, double imag = 0) : real{real}, imag{imag} {};
    friend ComplNum operator-(ComplNum &num1, ComplNum &num2);
    friend ComplNum operator-(ComplNum &complNum, double num);
    friend ComplNum operator-(double num, ComplNum &complNum);
    friend ComplNum operator--(ComplNum &complNum);
    friend ComplNum operator--(ComplNum &complNum, int notUsed);
    friend double absoluteValue(ComplNum &complNum);
    friend ostream &operator<<(ostream &os, ComplNum &complNum);
};

double absoluteValue(ComplNum &complNum){
    return sqrt(complNum.real*complNum.real + complNum.imag*complNum.imag);
}

ComplNum operator-(ComplNum &num1, ComplNum &num2)
{
    double real = num1.real - num2.real;
    double imag = num1.imag - num2.imag;
    return ComplNum(real, imag);
}

ComplNum operator-(ComplNum &complNum, double num)
{
    complNum.real -= num;
    return complNum;
}

ComplNum operator-(double num, ComplNum &complNum)
{
    complNum.real -= num;
    complNum.imag = -complNum.imag;
    return complNum;
}

ComplNum operator--(ComplNum &complNum)
{
    complNum.real--;
    complNum.imag--;
    return complNum;
}

ComplNum operator--(ComplNum &complNum, int notUsed)
{
    ComplNum temp = complNum;
    complNum.real--;
    complNum.imag--;
    return temp;
}

ostream &operator<<(ostream &os, ComplNum &complNum)
{
    os << complNum.real;
    if (complNum.imag > 0)
    {
        return os << "+" << complNum.imag << "i" << endl;
    }
    else if (complNum.imag == 0)
    {
        return os << endl;
    }
    return os << complNum.imag << "i" << endl;
}

int main()
{
    ComplNum num1(5, 6);
    ComplNum num2(3, 4);
    ComplNum num3(3, -4);
    cout << absoluteValue(num3);
}