#include <string>
#include <vector>

using namespace std;

int solution(int n, int w, int num) {
    int answer = 0; // num을 포함해서 위로 몇 개인지 세므로 0부터 시작해서 찾으면 +1
    vector<int> floor(w); // [수정 1] 크기 w로 초기화
    
    // num의 가로 위치(인덱스) 찾기
    int checkIndex = 0;
    
    // 수학적으로 계산하는 것이 훨씬 빠르고 정확합니다.
    // (num - 1) / w : 몇 번째 층인지 (0부터 시작)
    // 층이 짝수(0, 2..)면 왼쪽->오른쪽, 홀수(1, 3..)면 오른쪽->왼쪽
    int row = (num - 1) / w;
    if (row % 2 == 0) {
        // 정방향 (1 -> w)
        checkIndex = (num - 1) % w;
    } else {
        // 역방향 (w -> 1)
        checkIndex = w - 1 - ((num - 1) % w);
    }
    
    // num 부터 시작해서 위로 쌓아올리기
    // num 위치에서 위로 쭉 올라가면서 n보다 작거나 같은지 확인
    int currentBox = num;
    
    while(currentBox <= n) {
        answer++; // 현재 박스 카운트
        
        // 다음 층의 같은 인덱스에 있는 숫자 계산
        // 한 층 올라갈 때마다 2*w 차이가 나거나 하는 규칙이 있지만,
        // 지그재그 패턴에서는 단순히 index만 알면 다음 층 숫자를 알기 쉽지 않습니다.
        // 하지만 "수직으로 위에 있는 상자"는 층(layer)만 다르고 가로 위치는 같습니다.
        
        // 따라서 다음 층의 박스 번호를 구하는 가장 쉬운 방법은
        // (현재 층 * w) + 가로위치... 가 아니라
        // 단순히 (현재 박스 + 2 * (해당 층의 끝 - 현재박스) + 1) 같은 복잡한 식 대신
        // 전체 층을 순회하는 것이 낫습니다.
        
        // 작성하신 코드의 의도를 살려 "수학적 규칙"으로 다음 박스를 찾습니다.
        // 현재 층(row)에 따라 더해야 하는 값이 달라집니다.
        
        int distToRight = w - 1 - checkIndex;
        int distToLeft = checkIndex;
        
        if (row % 2 == 0) {
            // 짝수 층(->): 위로 가려면 (오른쪽 끝까지 남은 거리 * 2) + 1 만큼 더해짐
            currentBox += (distToRight * 2) + 1;
        } else {
            // 홀수 층(<-): 위로 가려면 (왼쪽 끝까지 남은 거리 * 2) + 1 만큼 더해짐
            currentBox += (distToLeft * 2) + 1;
        }
        row++; // 다음 층으로 이동
    }
    
    return answer;
}