#include <iostream>
#include <vector>

using namespace std;
int board[128][128];
int sum = 0, white = 0, blue = 0;

void solve(int n, int startX, int startY)
{
    sum = 0;
    for (int i = startX; i < startX + n; i++)
    {
        for (int j = startY; j < startY + n; j++)
        {
            sum += board[i][j];
        }
    }
    if (sum == n * n)
    {
        blue += 1;
        return;
    }
    else if (sum == 0)
    {
        white += 1;
        return;
    }
    else
    {
        n = n / 2;
        solve(n, startX, startY);
        solve(n, startX + n, startY);
        solve(n, startX, startY + n);
        solve(n, startX + n, startY + n);
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;

    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < n; ++j)
        {
            cin >> board[i][j];
            sum += board[i][j];
        }
    }

    if (sum == n * n)
    {
        blue += 1;
        cout << white << "\n"
             << blue << "\n";
    }
    else if (sum == 0)
    {
        white += 1;
        cout << white << "\n"
             << blue << "\n";
    }
    else
    {
        n = n / 2;
        solve(n, 0, 0);
        solve(n, 0, n);
        solve(n, n, 0);
        solve(n, n, n);

        cout << white << "\n"
             << blue << "\n";
    }

    return 0;
}