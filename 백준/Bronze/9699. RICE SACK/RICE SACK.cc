#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int T;
    cin >> T;

    for (int caseNum = 1; caseNum <= T; ++caseNum) {
        int sacks[5];
        for (int i = 0; i < 5; ++i) {
            cin >> sacks[i];
        }

        int maxWeight = *max_element(sacks, sacks + 5);

        cout << "Case #" << caseNum << ": " << maxWeight << endl;
    }

    return 0;
}
