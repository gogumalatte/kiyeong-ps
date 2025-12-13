#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    vector<int> v;
    for(int i = 1; i * i <= yellow; ++i)
    {
        if(yellow % i == 0)
        {
            v.push_back(i);
        }
    }
    
    for(int i : v)
    {
        if((i + 2) * (yellow / i + 2) == brown + yellow)
        {
            answer.push_back(yellow/i + 2);
            answer.push_back(i+2);
        }
    }
    return answer;
}