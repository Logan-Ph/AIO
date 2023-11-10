#include <iostream>
#include <string>
#include <algorithm>
#include <fstream>
#include <sstream>

using namespace std;

class Time{
private:
    int hour=0;
    int minute=0;
public:
    Time() = default;
    Time(int ahour, int aminute){
        if (ahour <24){
            hour = ahour;
        }

        if (aminute <60){
            minute = aminute;
        }
    };

    int getHour(){return hour;};
    int getMinute(){return minute;};

    Time operator+(Time &time){
        int tempHour = hour + time.getHour();
        int tempMinute = minute + time.getMinute();

        int extra = 0;        
        if (tempMinute>=60){
            tempMinute-=60;
            extra+=1;
        };
        tempHour += extra;
        if (tempHour>=24){
            tempHour-=24;
        }
        return Time(tempHour,tempMinute);
    };

    friend ostream &operator<< (ostream &os, Time &time){
        return os << time.getHour() << ":" << time.getMinute()<< endl;
    };
};

int main(){
    Time *array = new Time[4];
    fstream dataFile;
    dataFile.open("data2.dat");

    for (int i=0; i<4;i++){
        stringstream ss;
        string line;
        getline(dataFile,line);
        ss << line;
        int hour;
        int minute;
        ss >> hour >> minute;
        Time *time = new Time(hour,minute);
        array[i] = *time;
    }    
    sort(array,array+4,[](Time t1, Time t2){
        if ((t1.getHour()>t2.getHour())||(t1.getHour()==t2.getHour() && t1.getMinute()> t2.getMinute())) {
            return false;
        }else {
            return true;
        }
    });

    cout << array[0];

}