#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int alphabets[26] = {};
    string s;
    cin >> s;
    for (int i = 0; i < s.length(); i++)
    {
        alphabets[s[i] - 'a'] += 1;
    }

    for (int i = 0; i < 26; i++)
    {
        cout << alphabets[i] << " ";
    }
    cout << "\n";

    return 0;
}