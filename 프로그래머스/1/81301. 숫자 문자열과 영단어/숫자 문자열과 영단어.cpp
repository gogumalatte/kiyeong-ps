#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string s) {
    int answer = 0;
    string answer_s = "";
    vector<string> nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    for(int i = 0; i < s.size(); i++)
    {
        if(s[i] >= '0' and s[i] <= '9')
        {
            answer_s.push_back(s[i]);
            cout << answer << "\n";
        }
        else
        {
            for(int j = 0; j < 10; j++)
            {
                if(nums[j] == s.substr(i, nums[j].size()))
                {
                    i += nums[j].size() - 1;
                    answer_s += to_string(j);
                    break;
                }
            }
            cout << answer << "\n";
        }
    }
    answer = stoi(answer_s);
    return answer;
}