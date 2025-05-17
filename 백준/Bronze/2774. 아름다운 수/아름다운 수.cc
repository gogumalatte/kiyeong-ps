#include <iostream>
#include <vector>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int num, cnt = 0;
        vector<int> arr(10, 0);
        cin >> num;
        while (num > 0)
        {
            arr[num % 10]++;
            num = num / 10;
        }

        for (int i = 0; i < 10; i++)
        {
            if (arr[i] > 0)
            {
                cnt++;
            }
        }
        cout << cnt << "\n";
    }

    return 0;
}