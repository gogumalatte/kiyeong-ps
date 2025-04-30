#include <iostream>

using namespace std;

int n, m, start = 0, last = 0;
int arr[1000000];

int solve(int start, int last)
{
    int result = 0;
    while (start <= last)
    {
        int mid = (start + last) / 2;
        long long sum = 0;
        for (int i = 0; i < n; i++)
        {
            int temp = arr[i] - mid;
            if (temp > 0)
                sum += temp;
        }

        if (sum >= m)
        {
            result = mid;
            start = mid + 1;
        }
        else
        {
            last = mid - 1;
        }
    }
    return result;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
        last = max(last, arr[i]);
    }

    int answer = solve(0, last);

    cout << answer << "\n";

    return 0;
}