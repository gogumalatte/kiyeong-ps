#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(int n, long long left, long long right) {
    vector<int> answer;

    // left 부터 right 까지 반복
    for (long long i = left; i <= right; ++i) {
        // 1. 현재 인덱스 i를 2차원 좌표 (row, col)로 변환
        int row = i / n;
        int col = i % n;
        
        // 2. 좌표를 이용해 값 계산: max(행, 열) + 1
        int val = max(row, col) + 1;
        
        // 3. 정답 배열에 추가
        answer.push_back(val);
    }

    return answer;
}