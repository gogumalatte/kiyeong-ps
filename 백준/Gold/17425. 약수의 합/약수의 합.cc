#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int t;
    cin >> t;
    vector<int> testCase(t);
    int maxN = 0;

    // step1. testCase로 받은 값 중 가장 큰 값을 찾음
    for (int i = 0; i < t; ++i)
    {
        cin >> testCase[i];
        if (testCase[i] > maxN)
        {
            maxN = testCase[i];
        }
    }

    // step2. g(x)를 누적합으로 구하기
    vector<long long> g(maxN + 1, 0);
    for (int d = 1; d <= maxN; ++d)
    {
        for (int x = d; x <= maxN; x += d)
        {
            g[x] += d;
        }
    }

    for (int i = 1; i <= maxN; ++i)
    {
        g[i] += g[i - 1];
    }

    for (int i : testCase)
    {
        cout << g[i] << "\n";
    }

    return 0;
}