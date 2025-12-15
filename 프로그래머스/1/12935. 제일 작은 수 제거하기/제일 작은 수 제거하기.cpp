#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    if(arr.size() == 1)
    {
        answer.push_back(-1);
    }
    else
    {
        int temp = 987654321;
        
        for(int i : arr)
        {
            if(i < temp)
            {
                temp = i;
            }
        }
        
        for(int i : arr)
        {
            if(i != temp)
            {
                answer.push_back(i);
            }
        }
    }
    return answer;
}