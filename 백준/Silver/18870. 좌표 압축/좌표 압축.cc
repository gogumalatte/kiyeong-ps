#include <iostream>
#include <vector>
#include <set>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N;
    cin >> N;
    vector<int> arr(N);
    set<int> s;

    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
        s.insert(arr[i]);
    }
    vector<int> checkNum(s.begin(), s.end());

    for (int i = 0; i < N; i++)
    {
        int cur = arr[i];
        int start = 0, last = checkNum.size() - 1;
        while (start <= last)
        {
            int mid = (start + last) / 2;
            if (checkNum[mid] == cur)
            {
                arr[i] = mid;
                break;
            }
            else if (checkNum[mid] < cur)
            {
                start = mid + 1;
            }
            else
            {
                last = mid - 1;
            }
        }
    }

    for (int i = 0; i < N; i++)
    {
        cout << arr[i] << " ";
    }
    cout << "\n";

    return 0;
}