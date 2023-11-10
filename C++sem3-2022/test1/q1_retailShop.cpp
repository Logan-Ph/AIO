#include <fstream>
#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <algorithm>
#include <utility>

using namespace std;

int main(int argc, char *argv[])
{
    string option = argv[1];
    if (option == "-w")
    {
        int n = 0;
        cout << "Enter total number of items: ";
        cin >> n;
        cin.ignore(sizeof(n), '\n');
        ofstream myFile("sellingItems.dat");

        for (int i = 0; i < n; i++)
        {
            string name;
            int price;
            cout << "Enter name of item: ";
            getline(cin, name);
            cout << "   > price: ";
            cin >> price;
            cin.ignore(sizeof(price), '\n');
            string line = name + " : " + to_string(price);
            myFile << line << endl;
        }
        myFile.close();
    }
    else if (option == "-r")
    {
        ifstream myFile("sellingItems.dat");
        while (!myFile.eof())
        {
            string line;
            getline(myFile, line);
            cout << line << endl;
        }
        myFile.close();
    }
    else if (option == "-s")
    {
        ifstream myFile("sellingItems.dat");
        vector<string> name;
        vector<int> price;
        while (!myFile.eof())
        {
            string line;
            getline(myFile, line);
            auto index = line.find(" : ");

            if (index != string::npos)
            {
                name.push_back(line.substr(0, index));
                price.push_back(stoi(line.substr(index + 3)));
            }
        }
        auto index = distance(price.begin(), min_element(price.begin(), price.end()));
        cout << name.at(index) << " : " << price.at(index) << endl;
    }
    else
    {
        cerr << "Wrong argument" << endl;
    }
}