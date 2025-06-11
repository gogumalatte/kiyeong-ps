#include <iostream>
#include <string>
#include <set>

using namespace std;

// 숫자 x에 대해 F(x)를 수행하는 함수
string F(string x) {
    char first_digit_char = x[0];
    int first_digit = first_digit_char - '0';
    int num_digits = x.size();
    int result = first_digit * num_digits;
    return to_string(result);
}

int main() {
    string x;
    cin >> x;

    set<string> visited;

    while (true) {
        if (visited.count(x)) {
            cout << "FA" << endl;
            return 0;
        }
        visited.insert(x);
        x = F(x);
    }

    cout << "NFA" << endl;
    return 0;
}
