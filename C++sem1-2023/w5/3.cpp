#include <iostream>
#include <string>
#include <iomanip>
#include <exception>

using namespace std;

void quesA()
{
    double a, b;
    cout << "Enter the number a: ";
    cin >> a;
    cin.ignore(1, '\n');
    cout << "Enter the number b: ";
    cin >> b;
    cin.ignore(1, '\n');
    while (b == 0)
    {
        cerr << "Can not divide by 0" << endl;
        cerr << "Please enter again: ";
        cin >> b;
        cin.ignore(1, '\n');
    }
    cout << setprecision(3);
    cout << "The result of the division is: " << a / b << endl;
}

void quesB()
{
    int chunkSize = 1024 * 1024; // 1 MB in bytes
    try
    {
        while (true)
        {
            char *buffer = new char[chunkSize];
            chunkSize += chunkSize;
        }
    }
    catch (const std::exception &e)
    {
        std::cout << "Total allocated: " << chunkSize << " bytes" << std::endl;
    }
}

int main()
{
    // quesA();
    quesB();
}