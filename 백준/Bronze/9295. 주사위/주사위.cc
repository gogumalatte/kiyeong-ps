#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;
    for (int i = 1; i <= n; ++i)
    {
        int a, b;
        cin >> a >> b;
        cout << "Case " << i << ": " << a + b << "\n";
    }

    return 0;
}