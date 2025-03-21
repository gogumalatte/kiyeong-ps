#include <bits/stdc++.h>
using namespace std;

long a, b, c, temp;
long solve(long b)
{
    if (b == 0)
    {
        return 1;
    }
    if (b == 1)
    {
        return a % c;
    }
    
    temp = solve(b / 2) % c;
    if (b % 2 == 0)
        return temp * temp % c;
    return temp * temp % c * a % c;
}

int main()
{
    cin >> a >> b >> c;
    cout << solve(b);
    return 0;
}