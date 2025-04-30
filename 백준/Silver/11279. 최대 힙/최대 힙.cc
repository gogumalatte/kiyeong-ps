#include <iostream>
#include <queue>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    
    int N;
    priority_queue<int> maxHeap;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        int temp;
        cin >> temp;
        if (temp == 0)
        {
            if (maxHeap.empty())
            {
                cout << 0 << "\n";
            }
            else
            {
                cout << maxHeap.top() << "\n";
                maxHeap.pop();
            }
        }
        else
        {
            maxHeap.push(temp);
        }
    }

    return 0;
}