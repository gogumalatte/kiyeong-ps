#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(int k, int m, vector<int> score) {
    int answer = 0;
    int box_size = m;
    sort(score.rbegin(), score.rend());
    while(m <= score.size())
    {
        answer += box_size * score[m-1];
        m += box_size;
    }
    
    return answer;
}