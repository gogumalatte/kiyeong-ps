#include <bits/stdc++.h>
using namespace std;

int n, q, q_num, temp;
set<int> s;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> n >> q;
    for (int i = 0; i < q; i++)
    {
        cin >> q_num;
        if (q_num == 1)
        {
            cin >> temp;
            s.insert(temp);
        }
        else if (q_num == 2)
        {
            cin >> temp;
            s.erase(temp);
        }
        else if (q_num == 3)
        {
            cout << n - s.size() << "\n";
        }
    }
    return 0;
}