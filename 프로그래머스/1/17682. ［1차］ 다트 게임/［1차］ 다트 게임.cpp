#include <string>
#include <cmath>
#include <vector>

using namespace std;

int solution(string dartResult) {
    int answer = 0;
    int index = -1;
    vector<int> answer_box(3);
    
    for(int i = 0; i < dartResult.length(); ++i)
    {
        if(dartResult[i] == '1' && dartResult[i+1] == '0')
        {
            ++index;
            ++i;
            answer_box[index] = 10;
        }
        else if(dartResult[i] >= '0' && dartResult[i] <= '9')
        {
            ++index;
            answer_box[index] = int(dartResult[i]) - '0';
        }
        else if(dartResult[i] == 'S')
        {
            answer_box[index] = answer_box[index];
        }
        else if(dartResult[i] == 'D')
        {
            answer_box[index] = answer_box[index] * answer_box[index];
        }
        else if(dartResult[i] == 'T')
        {
            answer_box[index] = answer_box[index] * answer_box[index] * answer_box[index];
        }
        else if(dartResult[i] == '*')
        {
            answer_box[index] = 2 * answer_box[index];
            answer_box[index-1] = 2 * answer_box[index-1];
        }
        else if(dartResult[i] == '#')
        {
            answer_box[index] = (-1) * answer_box[index];
        }
    }
    
    for(int i : answer_box)
    {
        answer += i;
    }
    
    return answer;
}