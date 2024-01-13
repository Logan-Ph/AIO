#include <iostream>
#include <fstream>
#include <sstream>

int main()
{
    std::ifstream myFile("a.txt");
    std::string line;
    while (std::getline(myFile, line))
    {
        std::stringstream ss(line);
        std::string name;
        std::string score1;
        std::string score2;
        std::getline(ss, name, ',');
        std::getline(ss,score1,',');
        std::getline(ss,score2,',');
        std::cout << name << score1 << score2 <<std::endl;
    }
    myFile.close();
}