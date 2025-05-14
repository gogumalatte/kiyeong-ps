#include <iostream>

using namespace std;

int main()
{
    int a, b, cnt = 0;
    cin >> a >> b;

    while (b > a)
    {
        if (b % 2 != 0 and b % 10 != 1)
        {
            break;
        }
        else if (b % 2 == 0)
        {
            b = b / 2;
            cnt++;
        }
        else if (b % 10 == 1)
        {
            b = (b - 1) / 10;
            cnt++;
        }
    }

    if (b == a)
    {
        cout << cnt + 1 << "\n";
    }
    else
    {
        cout << -1 << "\n";
    }
    
    return 0;
}