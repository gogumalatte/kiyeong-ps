#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int sc_sum = 0, sc_min_score = 100;

    for (int i = 0; i < 4; i++)
    {
        int score;
        cin >> score;
        sc_sum += score;
        if (score < sc_min_score)
        {
            sc_min_score = score;
        }
    }

    int temp = sc_sum - sc_min_score;

    int a, b;
    cin >> a;
    cin >> b;

    if (a > b)
    {
        cout << temp + a << "\n";
    }
    else
    {
        cout << temp + b << "\n";
    }

    return 0;
}