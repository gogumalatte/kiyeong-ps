#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        int n;
        cin >> n;
        map<string, int> clothes;
        for (int j = 0; j < n; j++)
        {
            string cloth, type;
            cin >> cloth >> type;
            if (clothes.find(type) == clothes.end())
            {
                clothes.insert({type, 1});
            }
            else
            {
                clothes[type] += 1;
            }
        }

        int answer = 1;
        for (auto it = clothes.begin(); it != clothes.end(); ++it)
        {
            answer *= (it->second + 1);
        }
        cout << answer - 1 << "\n";
    }
    return 0;
}