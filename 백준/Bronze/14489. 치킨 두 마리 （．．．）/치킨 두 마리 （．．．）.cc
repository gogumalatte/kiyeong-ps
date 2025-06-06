#include <iostream>

using namespace std;

int main()
{
    int a, b;
    int chicken;

    cin >> a >> b;
    cin >> chicken;

    if (a + b >= 2 * chicken)
    {
        cout << a + b - 2 * chicken << "\n";
    }
    else
    {
        cout << a + b << "\n";
    }

    return 0;
}