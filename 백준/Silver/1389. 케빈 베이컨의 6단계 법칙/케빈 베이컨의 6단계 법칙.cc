#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

int n, m, minRet = INT_MAX, answer = 0;

void solve(vector<vector<int>> arr, int start)
{
    vector<int> visited(n + 1, -1);
    queue<int> q;

    q.push(start);
    visited[start] = 0;
    while (!q.empty())
    {
        int temp = q.front();
        q.pop();

        for (int i : arr[temp])
        {
            if (visited[i] == -1)
            {
                q.push(i);
                visited[i] = visited[temp] + 1;
            }
        }
    }

    int curRet = 0;
    for (int i = 1; i <= n; i++)
    {
        curRet += visited[i];
    }

    if (minRet > curRet)
    {
        minRet = curRet;
        answer = start;
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> n >> m;
    vector<vector<int>> arr(n + 1);
    for (int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;
        arr[a].push_back(b);
        arr[b].push_back(a);
    }

    for (int i = 1; i <= n; i++)
    {
        solve(arr, i);
    }

    cout << answer << "\n";

    return 0;
}