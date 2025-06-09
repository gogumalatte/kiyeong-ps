#include <iostream>

using namespace std;

int main()
{
    int n, ret = 0;
    int a, b, c;
    cin >> n;
    cin >> a >> b >> c;

    if (a >= n)
    {
        ret += n;
    }
    else
    {
        ret += a;
    }

    if (b >= n)
    {
        ret += n;
    }
    else
    {
        ret += b;
    }

    if (c >= n)
    {
        ret += n;
    }
    else
    {
        ret += c;
    }

    cout << ret << "\n";

    return 0;
}