#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n, m;
    cin >> n >> m;
    int num[n + 1];
    num[0] = 0;

    // step1. 수 입력받기
    for (int i = 1; i < n + 1; i++)
    {
        cin >> num[i];
        num[i] = num[i] + num[i - 1];
    }

    // step2. 구간합 구하기
    for (int i = 0; i < m; i++)
    {
        int start, end;
        cin >> start >> end;
        cout << num[end] - num[start - 1] << "\n";
    }
    return 0;
}