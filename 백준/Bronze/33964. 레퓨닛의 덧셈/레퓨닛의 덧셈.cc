#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int a, b;

    cin >> a >> b;

    if (a > b)
    {
        int digit_one = a - b;
        for (int i = 0; i < digit_one; ++i)
        {
            cout << "1";
        }
        for (int i = 0; i < b; ++i)
        {
            cout << "2";
        }
        cout << "\n";
    }
    else
    {
        int digit_one = b - a;
        for (int i = 0; i < digit_one; ++i)
        {
            cout << "1";
        }
        for (int i = 0; i < a; ++i)
        {
            cout << "2";
        }
        cout << "\n";
    }

    return 0;
}