#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;
    int arr[n + 1];
    arr[1] = 1;
    for (int i = 2; i < n + 1; i++)
    {
        if (i % 2 == 0)
        {
            arr[i] = (arr[i - 1] * 2 + 1) % 10007;
        }
        else
        {
            arr[i] = (arr[i - 1] * 2 - 1) % 10007;
        }
    }
    cout << arr[n] << "\n";

    return 0;
}