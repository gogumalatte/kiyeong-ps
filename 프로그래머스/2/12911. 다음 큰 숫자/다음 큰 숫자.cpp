#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(int n) {
    int answer = 0;
    vector<int> box;
    int check = false;
    int cnt = 0;
    int end_index = -1;
    
    // step1. 2진수로 바꾸기
    while(n)
    {
        box.push_back(n%2);
        n /=  2;
    }
    
    // step2. 다음 수 만들기
    for(int i = 0; i < box.size(); ++i)
    {
        if(check == false && box[i] == 1)
        {
            check = true;
        }
        else if(check == true && box[i] == 1)
        {
            cnt++;
        }
        else if(check == true && box[i] == 0)
        {
            box[i-1] = 0;
            box[i] = 1;
            end_index = i - 2;
            check = false;
            break;
        }
    }
    
    if(check)
    {
        box[box.size()-1] = 0;
        box.push_back(1);
        end_index = box.size() - 2;
    }
    
    for(int i = 0; i < cnt; ++i)
    {
        box[i] = 1;
    }
    for(int i = cnt; i <= end_index; ++i)
    {
        box[i] = 0;
    }
    
    // step3. 다음 수 이진수 -> 자연수로 바꾸기
    for(int i = 0; i < box.size(); ++i)
    {
        answer += (box[i] * pow(2, i));
    }
    
    return answer;
}