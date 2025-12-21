#include <string>
#include <algorithm>

using namespace std;

string solution(string s) {
    string answer = "";
    int index = 0;
    for(char c : s)
    {
        index++;
        
        if(c == ' ')
        {
            index = 0;
            answer += c;
        }
        else if(index == 1)
        {
            answer += toupper(c);
        }
        else
        {
            answer += tolower(c);
        }
    }
    return answer;
}