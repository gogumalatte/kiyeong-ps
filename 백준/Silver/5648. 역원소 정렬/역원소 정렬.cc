#include <bits/stdc++.h>
using namespace std;

vector<long> arr;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie();

    int n;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        string temp;
        cin >> temp;
        reverse(temp.begin(), temp.end());
        arr.push_back(stol(temp));
    }

    sort(arr.begin(), arr.end());
    for (long it : arr)
    {
        cout << it << "\n";
    }

    return 0;
}