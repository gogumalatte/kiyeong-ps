#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int n;
    cin >> n;

    vector<int> arr;

    arr.push_back(0);
    arr.push_back(1);

    for (int i = 2; i <= 20; i++)
    {
        arr.push_back(arr[i - 1] + arr[i - 2]);
    }

    cout << arr[n] << "\n";

    return 0;
}