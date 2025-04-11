#include <iostream>
#include <algorithm>
#include <vector>
#include <set>

using namespace std;
int N, M;
vector<int> arr;
vector<int> sequence;
set<vector<int>> result;

void solve(int depth, int cur)
{
    if (depth == M)
    {
        result.insert(sequence);
        return;
    }

    for (int i = cur; i < N; i++)
    {
        sequence.push_back(arr[i]);
        solve(depth + 1, i + 1);
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

    for (auto it : result)
    {
        for (int i : it)
        {
            cout << i << " ";
        }
        cout << "\n";
    }

    return 0;
}