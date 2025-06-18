#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int N, M, K;
    cin >> N >> M >> K;

    int frontO = M;
    int frontX = N - M;
    int backO = K;
    int backX = N - K;

    int sameO = min(frontO, backO);
    int sameX = min(frontX, backX);

    cout << sameO + sameX << endl;
    return 0;
}
