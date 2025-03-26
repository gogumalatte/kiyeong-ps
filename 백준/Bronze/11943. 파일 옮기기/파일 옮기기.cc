#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int a, b, c, d;
    cin >> a >> b;
    cin >> c >> d;

    if (b + c < a + d)
    {
        cout << b + c << "\n";
    }
    else
    {
        cout << a + d << "\n";
    }

    return 0;
}