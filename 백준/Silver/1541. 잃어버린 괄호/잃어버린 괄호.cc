#include <bits/stdc++.h>
using namespace std;

string calculation;
int cur = 0, temp = 0, ans = 0;
vector<string> firstStep; // operator와 operand를 분리해서 담을 배열
vector<int> secondStep;   // operator에 "-"만 남도록 처리한 배열

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> calculation;

    // step1. operator와 operand를 분리
    for (int i = 0; i < calculation.length(); i++)
    {
        if (calculation[i] == '+' || calculation[i] == '-')
        {
            firstStep.push_back(calculation.substr(cur, i - cur));
            if (calculation[i] == '+')
                firstStep.push_back("+");
            else
                firstStep.push_back("-");
            cur = i + 1;
        }
    }
    firstStep.push_back(calculation.substr(cur));
    cur = 0;

    // step2. 더하기 연산을 (괄호로 묶어) 먼저 처리
    for (int i = 0; i < firstStep.size(); i++)
    {
        if (i % 2 == 0)
            temp += stoi(firstStep[i]);
        if (firstStep[i] == "-")
        {
            secondStep.push_back(temp);
            temp = 0;
        }
    }
    secondStep.push_back(temp);

    // step3. 첫번째 수에서 뒤에 남은 수를 모두 빼준다.
    ans = secondStep[0];
    for (int i = 1; i < secondStep.size(); i++)
        ans -= secondStep[i];
    cout << ans << "\n";

    return 0;
}