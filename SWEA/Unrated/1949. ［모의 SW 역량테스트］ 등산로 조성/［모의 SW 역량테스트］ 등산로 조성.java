import java.util.*;
import java.io.*;

public class Solution {
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N;
	static int K;
	static int[][] board;
	static ArrayList<Point> startPoint;
	static int startValue;
	static int res;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input등산로조성.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new int[N][N];
			startPoint = new ArrayList<>();
			startValue = 0;
			res = 0;
			
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					board[i][j] = Integer.parseInt(st.nextToken());
					startValue = Math.max(startValue, board[i][j]);
				}
			}
			
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					if(board[i][j] == startValue) {
						startPoint.add(new Point(i, j));
					}
				}
			}
			
			for(Point p : startPoint) {
				for(int k = 0; k <= K; ++k) {
					for(int i = 0; i < N; ++i) {
						for(int j = 0; j < N; ++j) {
							if(p.x == i && p.y == j) continue;
							
							board[i][j] -= k;
							visited = new boolean[N][N];
							dfs(p.x, p.y, 1);
							board[i][j] += k;
						}
					}
				}
			}
			
			System.out.println("#" + test_case + " " + res);
		}
		br.close();
	}
	
	private static void dfs(int x, int y, int depth) {
		res = Math.max(res, depth);
		visited[x][y] = true;
		
		for(int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if(!visited[nx][ny] && board[nx][ny] < board[x][y]) {
					dfs(nx, ny, depth + 1);
					visited[nx][ny] = false;
				}
			}
		}
		
	}
}