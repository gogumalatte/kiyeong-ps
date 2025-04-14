#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n, ans = 0;
vector<int> arr;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int temp;
        cin >> temp;
        ans += temp;
        arr.push_back(temp);
    }

    sort(arr.begin(), arr.end());
    ans = ans - arr[n - 1];

    cout << ans << "\n";

    return 0;
}