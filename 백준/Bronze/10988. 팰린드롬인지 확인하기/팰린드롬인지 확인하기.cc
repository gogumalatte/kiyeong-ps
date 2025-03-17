#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    // step1. 단어 받기
    string s;
    int is_pelin = 1;
    cin >> s;

    // step2. 단어를 순회하며 팰린드롬인지 확인
    for (int i = 0; i < s.length()/2; i++)
    {
        if(s[i] != s[s.length()-i-1])
        {
            is_pelin = 0;
        }
    }

    cout << is_pelin << "\n";

    return 0;
}