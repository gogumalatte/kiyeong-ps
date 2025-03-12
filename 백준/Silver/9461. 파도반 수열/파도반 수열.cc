#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    vector<long> arr(101);
    arr[0] = 1;
    arr[1] = 1;
    arr[2] = 1;
    arr[3] = 2;
    arr[4] = 2;

    for (int i = 5; i < 101; i++)
    {
        arr[i] = arr[i - 1] + arr[i - 5];
    }

    int T;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        int n;
        cin >> n;
        cout << arr[n-1] << "\n";
    }
    return 0;
}