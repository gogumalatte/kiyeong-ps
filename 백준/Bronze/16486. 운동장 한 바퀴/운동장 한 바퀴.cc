#include <iostream>
#include <iomanip> // for fixed, setprecision

using namespace std;

int main()
{
    double a, b;
    cin >> a >> b;

    const double pi = 3.14159265358979323846;
    double answer = 2 * a + 2 * pi * b;

    cout << fixed << setprecision(6) << answer << "\n";

    return 0;
}
