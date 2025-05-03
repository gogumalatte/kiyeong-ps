#include <iostream>
#include <algorithm>

using namespace std;

int dp[200001];

int main()
{
    int a, b;
    cin >> a >> b;

    int last = a > b ? a : b * 2;

    dp[a] = 0;
    for (int i = a - 1; i >= 0; i--)
    {
        dp[i] = dp[i + 1] + 1;
    }
    for (int i = a + 1; i <= last; i++)
    {
        dp[i] = dp[i - 1] + 1;
        if (i % 2 == 0)
        {
            dp[i] = min(dp[i / 2] + 1, dp[i]);
            dp[i - 1] = min(dp[i - 1], dp[i] + 1);
        }
    }

    // for (int i = 0; i <= last; i++)
    // {
    //     cout << i << "번째: " << dp[i] << "\n";
    // }

    cout << dp[b] << "\n";

    return 0;
}