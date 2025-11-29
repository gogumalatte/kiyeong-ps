#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<string>> board, int h, int w) {
    int answer = 0;
    int size = board.size();
    
    // 오른쪽 칸 확인
    if(w + 1 < board.size() && board[h][w] == board[h][w+1])
    {
        answer++;
    }
    
    // 왼쪽 칸 확인
    if(w - 1 >= 0 && board[h][w] == board[h][w-1])
    {
        answer++;
    }
    
    // 위 칸 확인
    if(h - 1 >= 0 && board[h][w] == board[h-1][w])
    {
        answer++;
    }
    
    // 아래 칸 확인
    if(h + 1 < board.size() && board[h][w] == board[h+1][w])
    {
        answer++;
    }
    
    
    return answer;
}