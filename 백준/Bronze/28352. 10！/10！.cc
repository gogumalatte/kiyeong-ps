#include <iostream>

using namespace std;

int main()
{
    int n;
    cin >> n;

    long long answer = 6;

    for (int i = 11; i <= n; i++)
    {
        answer = i * answer;
    }

    cout << answer << "\n";

    return 0;
}