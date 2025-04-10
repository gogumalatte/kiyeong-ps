#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

int N, M;
vector<int> arr;
vector<int> sequence;
set<vector<int>> result;
vector<bool> used;

void solve(int depth)
{
    if (depth == M)
    {
        result.insert(sequence);
        return;
    }

    for (int i = 0; i < N; i++)
    {
        if (!used[i])
        {
            used[i] = true;
            sequence.push_back(arr[i]);
            solve(depth + 1);
            sequence.pop_back();
            used[i] = false;
        }
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
    used.resize(N, false);

    solve(0);
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