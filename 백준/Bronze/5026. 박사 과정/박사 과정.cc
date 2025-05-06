#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N;
    cin >> N;
    while (N--)
    {
        string problem;
        cin >> problem;
        if (problem == "P=NP")
        {
            cout << "skipped\n";
        }
        else
        {
            int plus_index = problem.find("+");
            int num1 = stoi(problem.substr(0, plus_index));
            int num2 = stoi(problem.substr(plus_index + 1));
            cout << num1 + num2 << "\n";
        }
    }

    return 0;
}