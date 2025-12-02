#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    int prev = -1;

    // 이전 숫자와 같지 않다면 추가
    for(int i : arr)
    {
        if(prev != i)
        {
            answer.push_back(i);
            prev = i;
        }
    }

    return answer;
}