#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string s) {
    string answer = "";
    string temp = "";
    vector<int> box;
    
    // step1. 문자열 s의 숫자들을 숫자 배열에 모두 저장
    for(int i = 0; i < s.length(); ++i)
    {
        if(s[i] == ' ')
        {
            box.push_back(stoi(temp));
            temp = "";
        }
        else
        {
            temp += s[i];
        }
    }
    box.push_back(stoi(temp));
    
    // step2. 배열을 오름차순으로 정렬
    sort(box.begin(), box.end());
    
    // step3. 최솟값, 최댓값을 공백으로 구분된 문자열로 저장
    answer = to_string(box[0]) + " " + to_string(box[box.size() - 1]);
    
    return answer;
}