#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer(2);
    while(true)
    {
        cout << s << '\n';
        int cur = 0;
        // 종료조건: 1이 될 때까지
        if(s == "1")
        {
            break;
        }
        
        for(char c : s)
        {
            if(c == '0')
            {
                answer[1]++;
                cur++;
            }
        }
        
        int next = s.size() - cur;
        s = "";
        cout << next << '\n';
        
        while(next)
        {
            s += to_string(next % 2);
            next /= 2;
        }
        
        answer[0]++;
    }
    
    return answer;
}