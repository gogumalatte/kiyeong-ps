#include <string>
#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    int left = 0;
    int right = people.size() - 1;
    
    // step1. 사람들을 몸무게 오름차순으로 정렬
    sort(people.begin(), people.end());
    
    // step2. 구명보트가 넘치면 다음 구명보트에 사람 구출
    while(left <= right)
    {
        if(people[left] + people[right] <= limit)
        {
            left++;
            right--;
        }
        else
        {
            right--;
        }
        answer++;
    }
    
    return answer;
}