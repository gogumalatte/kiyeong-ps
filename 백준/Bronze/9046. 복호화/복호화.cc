#include <bits/stdc++.h>
using namespace std;

int n, ret = 0, is_one = 0;
char answer;
string s;
int alphabets[26];

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    // step1. 테스트케이스 수 입력받고, 입력 버퍼를 비움.
    cin >> n;
    cin.ignore();

    for (int i = 0; i < n; i++)
    {
        // step2. 테스트케이스 마다 문자열을 입력받고, 문자열에 사용된 각 철자 수를 저장함.
        getline(cin, s);
        fill(alphabets, alphabets + 26, 0);
        ret = 0;
        is_one = 0;
        answer = 0;

        for (char it : s)
        {
            if (it >= 'a' && it <= 'z')
                alphabets[it - 'a']++;
        }

        // step3. 어떤 철자가 많이 쓰였는지 계산
        for (int j = 0; j < 26; j++)
        {
            ret = max(ret, alphabets[j]);
        }

        for (int j = 0; j < 26; j++)
        {
            if (ret == alphabets[j])
            {
                answer = j + 'a';
                is_one++;
            }
        }

        if (is_one == 1)
        {
            cout << answer << "\n";
        }
        else
        {
            cout << "?\n";
        }
    }

    return 0;
}