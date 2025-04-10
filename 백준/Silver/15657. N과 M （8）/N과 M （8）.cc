#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M;
vector<int> arr;
vector<int> sequence;

void solve(int depth, int cur)
{
    if (depth == M)
    {
        for (int i : sequence)
        {
            cout << i << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = cur; i < N; i++)
    {
        sequence.push_back(arr[i]);
        solve(depth + 1, i);
        sequence.pop_back();
    }
}

int main()
{
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        int temp;
        cin >> temp;
        arr.push_back(temp);
    }

    sort(arr.begin(), arr.end());
    solve(0, 0);

    return 0;
}