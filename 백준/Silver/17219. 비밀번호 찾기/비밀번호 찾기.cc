#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n, m;
    cin >> n >> m;
    map<string, string> address_to_name;
    for (int i = 0; i < n; i++)
    {
        string address, pw;
        cin >> address >> pw;
        address_to_name.insert({address, pw});
    }

    for(int i = 0; i < m; i++)
    {
        string q;
        cin >> q;
        cout << address_to_name[q] << "\n";
    }

    return 0;
}