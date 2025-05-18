#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N;
    cin >> N;

    for (int i = 0; i < N; ++i)
    {
        int number;
        cin >> number;

        int base = 10;
        while (base <= number)
        {
            int d = number % base;
            number = (number / base) * base;
            if (d >= base / 2)
                number += base;
            base *= 10;
        }

        cout << number << "\n";
    }

    return 0;
}
