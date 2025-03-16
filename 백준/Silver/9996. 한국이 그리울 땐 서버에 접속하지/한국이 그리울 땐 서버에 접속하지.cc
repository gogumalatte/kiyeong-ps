#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n, star_index;
    string pattern;
    cin >> n;
    cin >> pattern;

    star_index = pattern.find('*');

    for (int i = 0; i < n; i++)
    {
        string s;
        cin >> s;

        if (s.length() < pattern.length() - 1)
        {
            cout << "NE\n";
            continue;
        }

        string prefix = pattern.substr(0, star_index);
        string suffix = pattern.substr(star_index + 1);

        if (s.substr(0, star_index) == prefix && s.substr(s.length() - suffix.length()) == suffix)
        {
            cout << "DA\n";
        }
        else
        {
            cout << "NE\n";
        }
    }

    return 0;
}