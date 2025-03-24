#include <bits/stdc++.h>
using namespace std;

int a[10];
int b[10];
int ret = 0;

int main()
{
    for (int i = 0; i < 10; i++)
    {
        cin >> a[i];
    }

    for (int i = 0; i < 10; i++)
    {
        cin >> b[i];
    }

    for (int i = 0; i < 10; i++)
    {
        if (a[i] > b[i])
        {
            ret++;
        }
        else if (a[i] < b[i])
        {
            ret--;
        }
    }

    if (ret > 0)
    {
        cout << "A\n";
    }
    else if (ret == 0)
    {
        cout << "D\n";
    }
    else
    {
        cout << "B\n";
    }

    return 0;
}