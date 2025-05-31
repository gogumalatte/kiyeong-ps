#include <iostream>
using namespace std;

int main() {
    int S, T, D;
    cin >> S >> T >> D;

    double time = static_cast<double>(D) / (2 * S);
    double F = time * T;

    cout << static_cast<int>(F) << endl;

    return 0;
}
