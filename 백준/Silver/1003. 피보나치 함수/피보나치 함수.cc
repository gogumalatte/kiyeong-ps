#include <bits/stdc++.h>
using namespace std;
int fibo_zero[41], fibo_one[41];

int main()
{
    fibo_zero[0] = 1, fibo_one[0] = 0;
    fibo_zero[1] = 0, fibo_one[1] = 1;
    for (int i = 2; i < 41; i++)
    {
        fibo_zero[i] = fibo_zero[i - 1] + fibo_zero[i - 2];
        fibo_one[i] = fibo_one[i - 1] + fibo_one[i - 2];
    }
    int T;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        int n;
        cin >> n;
        cout << fibo_zero[n] << " " << fibo_one[n] << "\n";
    }
    return 0;
}