#include <iostream>

using namespace std;

int main()
{
    int tsum, tdiv;

    cin >> tsum >> tdiv;

    int a = (tsum + tdiv) / 2;
    int b = tsum - a;

    if (b > a)
    {
        int temp = a;
        a = b;
        b = temp;
    }

    if (a + b == tsum && a - b == tdiv && a >= 0 && b >= 0)
    {
        cout << a << " " << b << "\n";
    }
    else
    {
        cout << -1 << "\n";
    }

    return 0;
}