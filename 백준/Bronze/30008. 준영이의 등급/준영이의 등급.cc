#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int n, k;

    cin >> n >> k;
    vector<int> g(k, 0);
    vector<int> answer(k, 0);

    for (int i = 0; i < k; i++)
    {
        cin >> g[i];
    }

    for (int i = 0; i < k; i++)
    {
        double ch_score;
        ch_score = (g[i] * 100) / n;

        if (ch_score <= 4)
        {
            answer[i] = 1;
        }
        else if (ch_score <= 11)
        {
            answer[i] = 2;
        }
        else if (ch_score <= 23)
        {
            answer[i] = 3;
        }
        else if (ch_score <= 40)
        {
            answer[i] = 4;
        }
        else if (ch_score <= 60)
        {
            answer[i] = 5;
        }
        else if (ch_score <= 77)
        {
            answer[i] = 6;
        }
        else if (ch_score <= 89)
        {
            answer[i] = 7;
        }
        else if (ch_score <= 96)
        {
            answer[i] = 8;
        }
        else
        {
            answer[i] = 9;
        }
    }

    for (int temp : answer)
    {
        cout << temp << " ";
    }
    cout << '\n';

    return 0;
}