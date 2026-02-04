import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[][] maze = new int[16][16];
            int t = sc.nextInt();
            int startX = 0, startY = 0, finishX = 0, finishY = 0;
            int res = 0;
            for(int i = 0; i < 16; ++i) {
             	String s = sc.next();
                char[] charArr = s.toCharArray();
                for(int j = 0; j < charArr.length; ++j) {
                    maze[i][j] = charArr[j] - '0';
                    if(maze[i][j] == 2) {
                        startX = j;
                        startY = i;
                    }
                    if(maze[i][j] == 3) {
                        finishX = j;
                        finishY = i;
                    }
                }
            }

            Deque<int[]> visited = new ArrayDeque<>();
            int[] dx = {1, 0, -1, 0}; // 오른쪽, 아래, 왼쪽, 위
            int[] dy = {0, -1, 0, 1};

            visited.push(new int[] {startY, startX});
            maze[startY][startX] = -1;
            while(!visited.isEmpty()) {

                int[] cur = visited.peek();

                if(res == 1) {
                    break;
                }

                // 상하좌우 중 갈 수 있는 길이 있으면 이동
                int dir = 0;
                for( ; dir < 4; ++dir) {
                    int ny = cur[0] + dy[dir];
                    int nx = cur[1] + dx[dir];
                    
                    if(ny >= 0 && ny < 16 && nx >= 0 && nx < 16) {
                        if(maze[ny][nx] == 0 || maze[ny][nx] == 3) {
                            if(maze[ny][nx] == 3) {
                                res = 1;
                            }
                            maze[ny][nx] = -1;
                            visited.push(new int[] {ny, nx});
                            break;
                        }
                    }
                }

                // 갈 수 있는 길이 없으면, 한 칸 전으로 되돌아가기.
                if(dir == 4) {
                    visited.pop();
                }
            }

            
            System.out.println("#" + t + " " + res);
		}
	}
}