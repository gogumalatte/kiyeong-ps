#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;
    int dp[n + 1];
    dp[0] = 0;

    for (int i = 1; i < n + 1; i++)
    {
        dp[i] = dp[i - 1] + 1;
        for (int j = 1; j * j <= i; j++)
        {
            dp[i] = min(dp[i], dp[i - j * j] + 1);
        }
    }

    cout << dp[n] << "\n";

    return 0;
}