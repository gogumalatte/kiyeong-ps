#include <iostream>

using namespace std;

int n, maxCandy = 0;
char board[50][50];

void is_maxCandy()
{
    for (int i = 0; i < n; i++)
    {
        int temp = 1;
        for (int j = 0; j < n - 1; j++)
        {
            if (board[i][j + 1] == board[i][j])
            {
                temp += 1;
            }
            else
            {
                maxCandy = max(temp, maxCandy);
                temp = 1;
            }
        }
        maxCandy = max(temp, maxCandy);
    }
    for (int i = 0; i < n; i++)
    {
        int temp = 1;
        for (int j = 0; j < n-1; j++)
        {
            if (board[j+1][i] == board[j][i])
            {
                temp += 1;
            }
            else
            {
                maxCandy = max(temp, maxCandy);
                temp = 1;
            }
        }
        maxCandy = max(temp, maxCandy);
    }
}

int main()
{
    cin >> n;
    for (int row = 0; row < n; row++)
    {
        string temp;
        cin >> temp;
        for (int col = 0; col < n; col++)
        {
            board[row][col] = temp[col];
        }
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n - 1; j++)
        {
            swap(board[i][j], board[i][j + 1]);
            is_maxCandy();
            swap(board[i][j], board[i][j + 1]);
        }
    }

    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n; j++)
        {
            swap(board[i][j], board[i + 1][j]);
            is_maxCandy();
            swap(board[i][j], board[i + 1][j]);
        }
    }

    cout << maxCandy << "\n";

    return 0;
}