#include <iostream>
using namespace std;

int main()
{
    int a, b, c, d, e, ret = 0;
    cin >> a;
    cin >> b;
    cin >> c;
    cin >> d;
    cin >> e;

    if(a < 0)
    {
        ret += (0 - a) * c;
        ret += d;
        a = 0;
    }

    ret += (b - a) * e;

    cout << ret << "\n";

    return 0;
}