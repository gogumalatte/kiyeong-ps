#include <bits/stdc++.h>
using namespace std;

int alphabets[26];
int is_pelin = 0;

int main()
{
    // step1. 일단 단어를 받고 각 철자가 몇번 입력되었는지 저장
    string s;
    string answer = "";
    string middle = "";

    cin >> s;
    for (int i = 0; i < s.length(); i++)
    {
        alphabets[s[i] - 'A']++;
    }

    // step2. 홀수 횟수로 저장된 철자가 2개 이상이면 펠린드롬이 아님.
    for (int i = 0; i < 26; i++)
    {
        if (alphabets[i] % 2 != 0)
        {
            is_pelin++;
        }
    }

    // step3. 펠린드롬이 아닌 경우. I'm Sorry Hansoo를 출력, 맞을 경우 정답을 출력
    if (is_pelin > 1)
    {
        cout << "I'm Sorry Hansoo\n";
    }
    else
    {
        for (int i = 0; i < 26; i++)
        {
            if (alphabets[i] % 2 == 1)
            {
                middle = char(i + 'A');
            }
            for (int j = 0; j < alphabets[i] / 2; j++)
            {
                answer += char(i + 'A');
            }
        }
    }

    string temp = answer;
    reverse(temp.begin(), temp.end());
    answer = answer + middle + temp;

    cout << answer << "\n";

    return 0;
}