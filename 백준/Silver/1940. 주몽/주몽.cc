#include <bits/stdc++.h>
using namespace std;

int main()
{
    // step1. 재료를 받아서 고유한 번호 순대로 정렬 (오름차순)
    int n, m, cnt = 0;
    cin >> n;
    cin >> m;
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    sort(arr, arr + n);

    // step2. 정렬된 배열에 head, tail을 +1, -1 씩 하면서 head + tail이 m이 될 때 cnt++
    int head = 0, tail = n - 1;
    while (head < tail)
    {
        if (arr[head] + arr[tail] == m)
        {
            cnt++;
            head++;
            tail--;
        }
        else if (arr[head] + arr[tail] > m)
        {
            tail--;
        }
        else
        {
            head++;
        }
    }

    cout << cnt << "\n";

    return 0;
}