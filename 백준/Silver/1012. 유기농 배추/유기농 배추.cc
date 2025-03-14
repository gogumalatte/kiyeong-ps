#include <bits/stdc++.h>
using namespace std;

int t, m, n, k, x, y, ans;
int field[50][50];
int xpos[4] = {0, 0, -1, 1};
int ypos[4] = {1, -1, 0, 0};

// 양배추가 한덩어리로 있는 부분을 0으로 지우면서 ans를 1 올림.
void dfs(int x, int y)
{
    field[x][y] = 0;
    for (int i = 0; i < 4; i++)
    {
        int xx = x + xpos[i];
        int yy = y + ypos[i];
        if (xx < 0 || yy < 0 || xx >= m || yy >= n)
            continue;
        if (field[xx][yy] == 1)
        {
            dfs(xx, yy);
        }
    }
}

int main()
{
    cin >> t;
    for (int q = 0; q < t; q++)
    {
        cin >> m >> n >> k;
        for (int i = 0; i < k; i++)
        {
            cin >> x >> y;
            field[x][y] = 1;
        }

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (field[i][j] == 1)
                {
                    dfs(i, j);
                    ans++;
                }
            }
        }

        cout << ans << "\n";
        // 초기화
        ans = 0;
        for (int i = 0; i < m; i++)
        {
            fill(field[i], field[i] + n, 0);
        }
    }
}