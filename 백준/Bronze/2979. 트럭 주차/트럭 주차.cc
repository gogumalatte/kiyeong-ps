#include <bits/stdc++.h>
using namespace std;

int arr[3][101];
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int a, b, c, ans = 0;
    cin >> a >> b >> c;
    for (int i = 0; i < 3; i++)
    {
        int start, end;
        cin >> start >> end;
        for (int j = start; j < end; j++)
        {
            arr[i][j] = 1;
        }
    }

    for (int i = 0; i < 101; i++)
    {
        int sum = arr[0][i] + arr[1][i] + arr[2][i];
        if (sum == 1)
        {
            ans += a;
        }
        else if (sum == 2)
        {
            ans += b * 2;
        }
        else if (sum == 3)
        {
            ans += c * 3;
        }
    }
    cout << ans << "\n";

    return 0;
}