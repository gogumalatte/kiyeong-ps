import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int test_case = 1; test_case <= T; ++test_case) {
			int test_case_num = Integer.parseInt(br.readLine());
			int[][] maze = new int[16][16];
			int startX = 0;
			int startY = 0;
			
			for(int i = 0; i < 16; ++i) {
				String s = br.readLine();
				char[] charArray = s.toCharArray();
				for(int j = 0; j < 16; ++j) {
					maze[i][j] = charArray[j] - '0';
					if(maze[i][j] == 2) {
						startX = j;
						startY = i;
					}
				}
			}
			
			Queue<int[]> queue = new ArrayDeque<>();
			queue.offer(new int[] {startY, startX});
			maze[startY][startX] = -1;
			boolean isFindFinish = false;
			int[] dx = {1, 0, -1, 0};
			int[] dy = {0, -1, 0, 1};
			
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				if(isFindFinish) {
					break;
				}
				
				for(int i = 0; i < 4; ++i) {
					int nx = cur[1] + dx[i];
					int ny = cur[0] + dy[i];
					if(nx < 16 && nx >= 0 && ny < 16 && ny >= 0) {
						if(maze[ny][nx] == 0 || maze[ny][nx] == 3) {
							if(maze[ny][nx] == 0) {
								queue.offer(new int[] {ny, nx});
								maze[ny][nx] = -1;
							} else {
								System.out.println("#" + test_case_num + " 1");
								isFindFinish = true;
								break;
							}
						}
					}
				}
			}
			
			if(!isFindFinish) {
				System.out.println("#" + test_case_num + " 0");
			}
		}
	}
}