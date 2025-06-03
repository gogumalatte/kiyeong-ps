#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int n, boxSum = 0, last = 0;
    cin >> n;
    for (int i = 0; i < n; ++i)
    {
        int num;
        cin >> num;

        if (i == 0)
        {
            boxSum += num;
        }
        else
        {
            if (num != last + 1)
            {
                boxSum += num;
            }
        }
        last = num;
    }
    cout << boxSum << "\n";
    return 0;
}