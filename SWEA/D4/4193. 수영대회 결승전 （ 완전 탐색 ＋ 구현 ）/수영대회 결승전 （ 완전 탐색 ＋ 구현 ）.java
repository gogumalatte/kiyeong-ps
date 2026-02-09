import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static int[][] pool;
	
	public static class Position {
		int x, y, time;
		public Position(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; ++test_case) {
			n = Integer.parseInt(br.readLine());
			pool = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			int[] start = new int[2];
			int[] finish = new int[2];
			for(int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; ++j) {
					pool[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			finish[0] = Integer.parseInt(st.nextToken());
			finish[1] = Integer.parseInt(st.nextToken());
			
			Queue<Position> queue = new ArrayDeque<>();
			int[] dx = {1, 0, -1, 0};
			int[] dy = {0, -1, 0, 1};
			int res = -1;
			queue.offer(new Position (start[1], start[0], 0));
			visited[start[0]][start[1]] = true;
			
			while(!queue.isEmpty()) {
				Position cur = queue.poll();
				
				if(cur.y == finish[0] && cur.x == finish[1]) {
					res = cur.time;
					break;
				}
				
				for(int dir = 0; dir < 4; ++dir) {
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];
					
					if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
						if(pool[ny][nx] == 0 && !visited[ny][nx]) {
							queue.offer(new Position(nx, ny, cur.time + 1));
							visited[ny][nx] = true;
						}
						if(pool[ny][nx] == 2 && !visited[ny][nx]) {
							if(cur.time % 3 == 2) {
								queue.offer(new Position(nx, ny, cur.time + 1));
								visited[ny][nx] = true;
							} else {
								queue.offer(new Position(cur.x, cur.y, cur.time + 1));
							}
						}
					}
				}
			}
			
			System.out.println("#" + test_case + " " + res);
		}
	}
}