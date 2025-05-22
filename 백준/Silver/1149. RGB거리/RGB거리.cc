#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N;
    cin >> N;

    vector<vector<int>> cost(N, vector<int>(3));
    for (int i = 0; i < N; i++)
    {
        cin >> cost[i][0] >> cost[i][1] >> cost[i][2];
    }

    vector<int> prev = {cost[0][0], cost[0][1], cost[0][2]};
    vector<int> curr(3);

    for (int i = 1; i < N; i++)
    {
        curr[0] = cost[i][0] + min(prev[1], prev[2]);
        curr[1] = cost[i][1] + min(prev[0], prev[2]);
        curr[2] = cost[i][2] + min(prev[0], prev[1]);

        prev = curr;
    }

    cout << min({prev[0], prev[1], prev[2]});

    return 0;
}