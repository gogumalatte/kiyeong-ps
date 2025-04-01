#include <bits/stdc++.h>
using namespace std;

double arr[1000][2];

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    // step1. 좌표 받기
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i][0] >> arr[i][1];
    }

    // step2. 테스트 케이스 받아서 결과 출력
    int t, start, end;
    double sum = 0;
    cin >> t;
    for (int i = 0; i < t; i++)
    {
        int temp;
        cin >> temp;
        cin >> end;
        start = end;

        for (int j = 1; j < temp; j++)
        {
            start = end;
            cin >> end;
            sum += sqrt(pow(arr[end][0] - arr[start][0], 2) + pow(arr[end][1] - arr[start][1], 2));
        }

        cout << fixed;
        cout.precision(0);
        cout << sum << "\n";
        sum = 0;
    }

    return 0;
}