#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int t;
    cin >> t;
    while (t--)
    {
        int arr[26] = {
            0,
        };
        string s;
        cin >> s;
        for (char c : s)
        {
            arr[c - 'A']++;
        }

        int q;
        cin >> q;
        for (int i = 0; i < q; i++)
        {
            string temp;
            int test[26] = {
                0,
            };
            bool is_possible = true;
            cin >> temp;
            for (char t : temp)
            {
                test[t - 'A']++;
            }

            for (int j = 0; j < 26; j++)
            {
                if (test[j] > arr[j])
                {
                    is_possible = false;
                    break;
                }
            }

            if (is_possible)
            {
                cout << "YES\n";
            }
            else
            {
                cout << "NO\n";
            }
        }
    }

    return 0;
}