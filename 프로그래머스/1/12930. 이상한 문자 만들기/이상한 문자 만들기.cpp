#include <string>
#include <vector>

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
        else if(index % 2 == 1)
        {
            answer += toupper(c);
        }
        else if(index % 2 == 0)
        {
            answer += tolower(c);
        }
    }
    return answer;
}