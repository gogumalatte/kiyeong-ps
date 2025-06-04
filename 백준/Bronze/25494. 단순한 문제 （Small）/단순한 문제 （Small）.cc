#include <iostream>
using namespace std;

int countValidTriplets(int a, int b, int c) {
    int count = 0;
    for (int x = 1; x <= a; ++x) {
        for (int y = 1; y <= b; ++y) {
            for (int z = 1; z <= c; ++z) {
                int r1 = x % y;
                int r2 = y % z;
                int r3 = z % x;
                if (r1 == r2 && r2 == r3) {
                    ++count;
                }
            }
        }
    }
    return count;
}

int main() {
    int T;
    cin >> T;

    while (T--) {
        int a, b, c;
        cin >> a >> b >> c;
        cout << countValidTriplets(a, b, c) << '\n';
    }

    return 0;
}
