#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int t;
    cin >> t;
    cin.ignore();

    while (t--)
    {
        string s;
        vector<int> ret;
        int temp = 0;
        getline(cin, s);

        for (char c : s)
        {
            if (c == ' ')
            {
                ret.push_back(temp % 27);
                temp = 0;
            }
            else
            {
                temp += c - 'a';
            }
        }
        ret.push_back(temp % 27);

        for (int i : ret)
        {
            if (i == 26)
            {
                cout << " ";
            }
            else
            {
                cout << (char)('a' + i);
            }
        }
        cout << "\n";
    }

    return 0;
}