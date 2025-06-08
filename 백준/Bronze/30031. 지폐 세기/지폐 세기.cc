#include <iostream>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n, total = 0;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        int x, y;
        cin >> x >> y;
        if (x == 136)
        {
            total += 1000;
        }
        else if (x == 142)
        {
            total += 5000;
        }
        else if (x == 148)
        {
            total += 10000;
        }
        else if (x == 154)
        {
            total += 50000;
        }
    }

    cout << total << "\n";

    return 0;
}