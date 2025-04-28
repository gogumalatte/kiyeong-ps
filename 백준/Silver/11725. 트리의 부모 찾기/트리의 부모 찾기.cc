#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N;
    cin >> N;
    vector<vector<int>> adj(N + 1);
    for (int i = 0, u, v; i < N - 1; i++)
    {
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    vector<int> parent(N + 1, 0);
    queue<int> q;
    parent[1] = 1;

    // q에 1을 넣고 BFS 순회
    q.push(1);
    while (!q.empty())
    {
        int cur = q.front();
        q.pop();
        for (int nx : adj[cur])
        {
            if (parent[nx] == 0)
            {
                parent[nx] = cur;
                q.push(nx);
            }
        }
    }

    for (int i = 2; i <= N; i++)
    {
        cout << parent[i] << "\n";
    }

    return 0;
}