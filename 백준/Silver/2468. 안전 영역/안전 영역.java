import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] board;
	static int res;
	static int maxHigh;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("bj2468.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		res = 0;
		maxHigh = 0;
		
		for(int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
				maxHigh = Math.max(maxHigh, board[i][j]);
			}
		}
		
		solve();
		
		System.out.println(res);
	}
	
	private static void solve() {
		for(int h = 0; h < maxHigh; ++h) {
			int cur = bfs(h);
			res = Math.max(res, cur);
		}
	}
	
	private static int bfs(int height) {
		int cnt = 0;
		boolean[][] visited = new boolean[N][N];
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(board[i][j] > height && !visited[i][j]) {
					cnt++;
					ArrayDeque<Point> queue = new ArrayDeque<>();
					queue.offer(new Point(i, j));
					visited[i][j] = true;
					
					while(!queue.isEmpty()) {
						Point cur = queue.poll();
						
						for(int dir = 0; dir < 4; ++dir) {
							int nx = cur.x + dx[dir];
							int ny = cur.y + dy[dir];
							
							if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
								if(board[nx][ny] > height && !visited[nx][ny]) {
									queue.offer(new Point(nx, ny));
									visited[nx][ny] = true;
								}
							}
						}
					}
				}
			}
		}
		
		return cnt;
	}
}
