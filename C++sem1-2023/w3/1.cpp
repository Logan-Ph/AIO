#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int main()
{
    int choice = 1;
    while (choice != 0)
    {
        string pwd;
        cout << "Password management program:" << endl;
        cout << "1. Save your password" << endl;
        cout << "2. Read your password" << endl;
        cout << "Enter '0' to exit" << endl;
        cout << "Your choice: ";
        cin >> choice;
        cin.ignore(sizeof(choice), '\n');
        fstream outputFile;
        fstream inputFile;
        switch (choice)
        {
        case 1:
            outputFile.open("pwd.dat",ios::out);
            cout << "Enter the password: ";
            getline(cin, pwd);
            outputFile << pwd;
            outputFile.close();
            break;
        case 2:
            inputFile.open("pwd.dat",ios::in);
            if (!inputFile)
            {
                cout << "The file does not exist!" << endl;
            }
            else
            {
                cout << "Your password is: ";
                getline(inputFile, pwd);
                cout << pwd << endl;
            }
            inputFile.close();
            break;
        }
    }
}