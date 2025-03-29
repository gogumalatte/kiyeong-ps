#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n, q;
    cin >> n >> q;
    vector<bool> infected(n + 1, false);
    int uninfectedCount = n;

    for (int i = 0; i < q; i++)
    {
        int command;
        cin >> command;

        if (command == 1)
        {
            int x;
            cin >> x;
            if (!infected[x])
            {
                infected[x] = true;
                uninfectedCount--;
            }
        }
        else if (command == 2)
        {
            int x;
            cin >> x;
            if (infected[x])
            {
                infected[x] = false;
                uninfectedCount++;
            }
        }
        else if (command == 3)
        {
            cout << uninfectedCount << "\n";
        }
    }
    return 0;
}