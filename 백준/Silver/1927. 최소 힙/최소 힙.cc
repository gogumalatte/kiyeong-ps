#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    priority_queue<int, vector<int>, greater<int>> minHeap;

    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        if (x != 0)
        {
            minHeap.push(x);
        }
        else
        {
            if (minHeap.empty())
            {
                cout << 0 << "\n";
            }
            else
            {
                cout << minHeap.top() << "\n";
                minHeap.pop();
            }
        }
    }

    return 0;
}