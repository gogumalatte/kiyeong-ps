#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

int n, m;
int board[1000][1000];
bool visited[1000][1000];
int moveX[4] = {0, 0, 1, -1};
int moveY[4] = {1, -1, 0, 0};

void bfs(int x, int y)
{
    queue<pair<int, int>> q;
    q.push({x, y});
    visited[x][y] = true;

    while (!q.empty())
    {
        auto [cx, cy] = q.front();
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nx = cx + moveX[i];
            int ny = cy + moveY[i];

            if (nx >= 0 and nx < n and ny >= 0 and ny < m)
            {
                if (!visited[nx][ny] && board[nx][ny] == -1)
                {
                    visited[nx][ny] = true;
                    board[nx][ny] = board[cx][cy] + 1;
                    q.push({nx, ny});
                }
            }
        }
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int startX, startY;
    cin >> n >> m;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            int temp;
            cin >> temp;
            if (temp == 2) // 시작점
            {
                startX = i;
                startY = j;
                board[i][j] = 0;
            }
            else if (temp == 1) // 아직 도달 못함
            {
                board[i][j] = -1;
            }
            else // 벽
            {
                board[i][j] = -2;
            }
        }
    }

    bfs(startX, startY);

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (board[i][j] == -2)
                cout << 0 << " ";
            else
                cout << board[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}