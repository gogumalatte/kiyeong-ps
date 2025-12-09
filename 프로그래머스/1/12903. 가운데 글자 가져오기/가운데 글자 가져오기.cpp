#include <string>

using namespace std;

string solution(string s) {
    string answer = "";
    
    int s_size = s.length();
    if(s_size % 2 == 0) // 짝수일때
    {
        answer += s[s_size / 2 -1];
        answer += s[s_size / 2];
    }
    else // 홀수일때
    {
        answer += s[s_size / 2];
    }
    
    return answer;
}