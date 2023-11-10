#include "iostream"
#include "string"
using namespace std;

void funcA(){
    double a,b;
    cout << "Please enter the number a" << endl;
    cin >> a;
    cin.ignore(sizeof (a),'\n');
    cout << "Please enter the number b" << endl;
    cin >> b;
    cin.ignore(sizeof (a),'\n');
    while (true){
        try {
            if(b == 0) {
                throw invalid_argument("Divide by zero error!");
            }
            double result = a / b;
            std::cout << a << " / " << b << " = " << result << std::endl;
            break;
        }catch (invalid_argument &invalid_argument){
            std::cout << invalid_argument.what() << std::endl;
            std::cout << "Please re-enter value for b: " << endl;
            std::cin >> b;
            cin.ignore(sizeof (b), '\n');
        }
    }
}

void funcB(){
    const int MB = 1024*1024;
    char *buffer;
    int  current = 0;
    while (true){
        try{
            buffer = new char[current];
            current += MB;
        }catch (bad_alloc &alloc){
            cout << "Bad allocation " << alloc.what() << endl;
            break;
        }
    }
}

//int main(){
//    funcA();
//    funcB();
//}

