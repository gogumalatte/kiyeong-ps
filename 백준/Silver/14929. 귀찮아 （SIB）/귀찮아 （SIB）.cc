#include <bits/stdc++.h>
using namespace std;

long long arr[100001];

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    long long ret = 0;
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        int temp;
        cin >> arr[i];
        ret += arr[i - 1] * arr[i];
        arr[i] = arr[i - 1] + arr[i];
    }

    cout << ret << "\n";

    return 0;
}