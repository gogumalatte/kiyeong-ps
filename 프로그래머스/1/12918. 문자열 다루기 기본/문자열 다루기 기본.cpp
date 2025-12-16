#include <string>

using namespace std;

bool solution(string s) {
    bool answer = false;
    int length = 0;
    
    for(char c : s)
    {
        length++;
        if(c < '0' || c > '9')
        {
            return answer;
        }
    }
    
    if(length == 4 || length == 6)
    {
        answer = true;
    }
    
    return answer;
}