#include <bits/stdc++.h>
using namespace std;

int n, jump, arr[100];

int main()
{
    cin >> n;

    // step1. 한칸씩 밀고 넣기.
    for (int i = 0; i < n; i++)
    {
        cin >> jump;
        for (int j = i; j > i - jump; j--)
        {
            arr[j] = arr[j - 1];
        }
        arr[i - jump] = i + 1;
    }

    // step2. 출력
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    return 0;
}