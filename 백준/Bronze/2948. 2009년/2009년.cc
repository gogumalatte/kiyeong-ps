#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    string weeks[7] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    int months[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int M, D;
    cin >> D >> M;

    int days = 0;
    for (int i = 0; i < M - 1; i++)
    {
        days += months[i];
    }
    days += D;
    days = (days + 2) % 7;

    cout << weeks[days] << "\n";

    return 0;
}