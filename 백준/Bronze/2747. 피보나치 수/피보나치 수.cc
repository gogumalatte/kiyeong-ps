#include <iostream>

using namespace std;

int n;
int pibo[51];

int main()
{
    pibo[0] = 0;
    pibo[1] = 1;

    cin >> n;

    for (int i = 2; i <= n; i++)
    {
        pibo[i] = pibo[i - 1] + pibo[i - 2];
    }

    cout << pibo[n] << "\n";

    return 0;
}