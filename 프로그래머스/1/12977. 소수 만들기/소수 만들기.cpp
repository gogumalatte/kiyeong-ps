#include <vector>
#include <set>
#include <iostream>
using namespace std;

int solution(vector<int> nums) {
    int answer = 0;
    vector<int> sum_list;

    // step1. 세 수의 합 저장
    for(int i = 0; i < nums.size() - 2; ++i)
    {
        for(int j = i + 1; j < nums.size() - 1; ++j)
        {
            for(int k = j + 1; k < nums.size(); ++k)
            {
                sum_list.push_back(nums[i] + nums[j] + nums[k]);
            }
        }
    }
    
    // 세 수의 합이 소수인지 확인
    for(int i : sum_list)
    {
        int check = 0;
        for(int j = 2; j < i; ++j)
        {
            if(i % j == 0)
            {
                check++;
            }
        }
        
        if(check == 0)
        {
            answer++;
        }
    }

    return answer;
}