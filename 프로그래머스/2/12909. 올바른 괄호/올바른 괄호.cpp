#include <string>
#include <stack>
#include <iostream>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    stack <char> box;

    for(int i = 0; i < s.length(); ++i)
    {
        if(s[i] == '(')
        {
            box.push('(');
        }
        else
        {
            if(box.size() == 0)
            {
                answer = false;
                break;
            }
            else
            {
                box.pop();
            }
        }
    }
    
    if(box.size() != 0)
    {
        answer = false;
    }

    return answer;
}