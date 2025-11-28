#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer(N);
    vector<double> fail_percent(N);
    
    // step1. 실패율 계산하기
    for(int i = 1; i <= N; ++i)
    {
        double top = 0;
        double bottom = 0;
        for(int j = 0; j < stages.size(); ++j)
        {
            if(stages[j] >= i)
            {
                bottom++;
            }
            if(stages[j] == i)
            {
                top++;
            }
        }
        
        if (bottom == 0) {
            fail_percent[i-1] = 0;
        } else {
            fail_percent[i-1] = top / bottom;
        }
    }
    
    // 2. 정렬하기
    vector<double> temp = fail_percent;
    sort(temp.rbegin(), temp.rend());
    for(int i = 0; i < N; ++i)
    {
        for(int j = 0; j < N; ++j)
        {
            if(temp[i] == fail_percent[j])
            {
                answer[i] = j+1;
                fail_percent[j] = -1;
                break;
            }
        }
    }
    return answer;
}