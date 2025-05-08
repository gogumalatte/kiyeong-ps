#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N, left = 0, right = 0, maxCnt = 0;
    unordered_map<int, int> fruitCnt;

    cin >> N;
    vector<int> box(N);
    for (int i = 0; i < N; i++)
    {
        cin >> box[i];
    }

    while (right < N)
    {
        fruitCnt[box[right]]++;

        while (fruitCnt.size() > 2)
        {
            fruitCnt[box[left]]--;
            if (fruitCnt[box[left]] == 0)
            {
                fruitCnt.erase(box[left]);
            }
            left++;
        }
        maxCnt = max(maxCnt, right - left + 1);
        right++;
    }

    cout << maxCnt << "\n";

    return 0;
}