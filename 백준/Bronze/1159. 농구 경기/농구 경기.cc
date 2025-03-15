#include <bits/stdc++.h>
using namespace std;

int n, temp;
string player;
int players[26] = {};
vector<char> ans;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    // step1. 선수들 입력받기. (각 선수의 첫번째 알파벳에 맞게 1씩 더해줌)
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> player;
        temp = player[0] - 'a';
        players[temp] += 1;
    }

    // step2. 선수가 5명 이상이면 ans 배열에 담아주기.
    for (int i = 0; i < 26; i++)
    {
        if (players[i] >= 5)
            ans.push_back(char(i + 97));
    }

    // step3. 선수를 출력
    if (ans.size())
    {
        sort(ans.begin(), ans.end());
        for (int i = 0; i < ans.size(); i++)
        {
            cout << ans[i] << "";
        }
        cout << "\n";
    }
    else
    {
        cout << "PREDAJA" << "\n";
    }

    return 0;
}