#include <iostream>
#include <algorithm>

using namespace std;

int min(int array[], int n){
    return *min_element(array,array+n);
}

int main(int argc, char const *argv[])
{
    int n;
    int array[] = {1,2,4,-2,1};
    cout << "The smallest element in the array is " << min(array,size(array));
}
