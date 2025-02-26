#include <bits/stdc++.h>
using namespace std;
int T;
string s;
int main()
{
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> s;
        for (int j = 0; j < s.size(); j++)
        {
            s[j] = tolower(s[j]);
        }
        cout << s << '\n';
    }
}