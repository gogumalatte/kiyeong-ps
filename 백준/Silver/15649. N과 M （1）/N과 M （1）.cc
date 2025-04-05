#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<int> sequence;
vector<bool> used;

void solve(int depth)
{
    if (depth == m) // m개의 수를 고른 경우, 출력
    {
        for (int num : sequence)
        {
            cout << num << " ";
        }
        cout << "\n";
        return;
    }

    // 1부터 n까지 탐색
    for (int i = 1; i <= n; i++)
    {
        if (!used[i])
        {
            used[i] = true;
            sequence.push_back(i);
            solve(depth + 1);
            sequence.pop_back();
            used[i] = false;
        }
    }
}

int main()
{
    cin >> n >> m;

    used.resize(n + 1, false);
    solve(0);

    return 0;
}