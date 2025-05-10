#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n;
int answer[100][100];

void solve(vector<vector<int>> arr)
{
    for (int i = 0; i < n; i++)
    {
        queue<int> q;
        vector<bool> visited(n, false);

        for (int ii : arr[i])
        {
            q.push(ii);
            visited[ii] = true;
        }

        while (!q.empty())
        {
            int x = q.front();
            q.pop();

            for (int y : arr[x])
            {
                if (!visited[y])
                {
                    q.push(y);
                    visited[y] = true;
                }
            }
        }

        for (int iii = 0; iii < n; iii++)
        {
            if (visited[iii])
            {
                answer[i][iii] = 1;
            }
        }
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> n;
    vector<vector<int>> arr(n);

    for (int i = 0; i < n; i++)
    {
        for (int ii = 0; ii < n; ii++)
        {
            int temp;
            cin >> temp;
            if (temp == 1)
            {
                arr[i].push_back(ii);
            }
        }
    }

    solve(arr);

    for (int i = 0; i < n; i++)
    {
        for (int ii = 0; ii < n; ii++)
        {
            cout << answer[i][ii] << " ";
        }
        cout << "\n";
    }

    return 0;
}