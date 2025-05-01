#include <iostream>
#include <vector>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N, M, B;
    cin >> N >> M >> B;

    vector<vector<int>> ground(N, vector<int>(M));
    int minH = 256, maxH = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> ground[i][j];
            minH = min(minH, ground[i][j]);
            maxH = max(maxH, ground[i][j]);
        }
    }

    int resultTime = INT32_MAX;
    int resultHeight = 0;

    for (int h = minH; h <= maxH; h++)
    {
        int time = 0;
        int inventory = B;

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                int diff = ground[i][j] - h;
                if (diff > 0)
                {
                    time += diff * 2;
                    inventory += diff;
                }
                else
                {
                    time += -diff;
                    inventory += diff;
                }
            }
        }

        if (inventory >= 0)
        {
            if (time <= resultTime)
            {
                resultTime = time;
                resultHeight = h;
            }
        }
    }

    cout << resultTime << " " << resultHeight << "\n";

    return 0;
}