#include "iostream"
#include "fstream"
#include "string"

using namespace std;

void writingPass() {
    string pass;
    cout << "Enter the password" << endl;
    getline(cin, pass);
    fstream file;
    file.open("pwd.dat", ios::out);
    file << pass << endl;
    cout << "Writing password to file successfully";
    file.close();
}

void readingPass() {
    char pass[100];
    fstream file;
    file.open("pwd.dat", ios::in);
    file.getline(pass,sizeof (pass));
    file.close();
    cout << "Password: "<< pass << endl;
    cout << "Reading password successfully" << endl;
}

void display() {
    cout << "1. Save your password" << endl;
    cout << "2. Read your password" << endl;
}

//int main() {
//    int opCase;
//    display();
//    cout << "Choose your choice" << endl;
//    cin >> opCase;
//    cin.ignore(1, '\n');
//    switch (opCase) {
//        case 1:
//            writingPass();
//            break;
//        case 2:
//            readingPass();
//            break;
//        default:
//            cout << "Wrong operation" << endl;
//            break;
//    }
//}