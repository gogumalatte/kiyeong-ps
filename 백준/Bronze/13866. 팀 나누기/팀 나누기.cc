#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int a, b, c, d;

    cin >> a >> b >> c >> d;

    int x = a + d;
    int y = b + c;

    if(x > y)
    {
        cout << x - y << "\n";
    }
    else
    {
        cout << y - x << "\n";
    }

        return 0;
}