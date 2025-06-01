#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int n;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        for (int ii = 0; ii < i; ii++)
        {
            cout << " ";
        }

        for (int iii = n-1; iii > i; iii--)
        {
            cout << "**";
        }
        cout << "*";

        cout << "\n";
    }

    return 0;
}