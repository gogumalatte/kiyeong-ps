#include <iostream>
using namespace std;

int main()
{
    int n, x, cur = 0;
    cin >> n >> x;

    for (int i = 0; i < n; i++)
    {
        int s, t;
        cin >> s >> t;
        if (s + t <= x && s > cur)
        {
            cur = s;
        }
    }

    if (cur != 0)
    {
        cout << cur;
    }
    else
    {
        cout << -1;
    }

    return 0;
}