#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int x, y;
    cin >> x;
    cin >> y;

    cout << 2 * y - x << "\n";
    
    return 0;
}