#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    while (true)
    {
        string name;
        int age, weight;

        cin >> name >> age >> weight;

        if (name == "#" and age == 0 and weight == 0)
        {
            break;
        }

        if (age > 17 or weight >= 80)
        {
            cout << name << " Senior\n";
        }
        else
        {
            cout << name << " Junior\n";
        }
    }

    return 0;
}