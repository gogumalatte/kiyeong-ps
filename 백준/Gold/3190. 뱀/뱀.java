import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int board_size = sc.nextInt();
        int[][] board = new int[board_size+2][board_size+2];

        // 테두리 벽 만들기
        for(int i = 0 ; i < board.length; ++i) {
            board[0][i] = -1; // 상
            board[board.length - 1][i] = -1; //하
            board[i][0] = -1; //좌
            board[i][board.length - 1] = -1; //우
        }

        // 먹이 표시
        int preys = sc.nextInt();
        for(int i = 0; i < preys; ++i) {
            int prey_row = sc.nextInt();
            int prey_col = sc.nextInt();
            board[prey_row][prey_col] = 1;
        }

        // 뱀의 이동방향
        int[] dx = {1, 0, -1, 0}; // 오른쪽, 아래, 왼쪽, 위
        int[] dy = {0, 1, 0 , -1};
        int cur_dir = 0;

        // 뱀의 방향 전환 이벤트 정보
        int event_cnt = sc.nextInt();
        int[] eventTime = new int[event_cnt];
        char[] eventRotate = new char[event_cnt];
        int nextEvent = 0;
        for(int i = 0; i < event_cnt; ++i) {
            eventTime[i] = sc.nextInt();
            eventRotate[i] = sc.next().charAt(0);
        }

        int time = 0;
        int curx = 1;
        int cury = 1;
        Queue<int[]> snake_body = new LinkedList<>();

        board[cury][curx] = -1;
        snake_body.offer(new int[] {cury, curx});

        // 매초 움직이다가 부딪히면 정지
        while(true) {
            // 방향 전환을 필요하다면
            if(nextEvent < event_cnt && time == eventTime[nextEvent]) {
                if(eventRotate[nextEvent] == 'D') {
                    cur_dir = (cur_dir + 1) % 4;
                } else {
                    cur_dir = (cur_dir + 3) % 4;
                }
                nextEvent++;
            }
            
            // 해당되는 방향으로 한 칸 이동
            time++;
            curx += dx[cur_dir];
            cury += dy[cur_dir];
            
            // 벽이나 자신의 몸에 부딪히면
            if(board[cury][curx] == -1) {
                System.out.println(time);
                break;
            }

            // 먹이가 없다면
            if(board[cury][curx] == 0) {
                int[] last = snake_body.poll();
                board[last[0]][last[1]] = 0;
            }
            
            board[cury][curx] = -1;
            snake_body.offer(new int[] {cury, curx});
        }
        
    }
}