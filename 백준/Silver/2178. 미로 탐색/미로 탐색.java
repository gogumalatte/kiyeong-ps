import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] board;
	static boolean[][] visited;
	static int res;
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, -1, 0, 1};

	static class Point {
		int x, y, cnt;
		
		Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("bj2178.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];
		res = 0;
		
		for(int i = 0; i < N; ++i) {
			String line = br.readLine();
			for(int j = 0; j < M; ++j) {
				board[i][j] = line.charAt(j) - '0';
			}
		}
		
		bfs();
		
		System.out.println(res);
		br.close();
	}
	
	private static void bfs() {
		ArrayDeque<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(0, 0, 1));
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for(int i = 0; i < 4; ++i) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx == N - 1 && ny == M - 1) {
					res = cur.cnt + 1;
					break;
				}
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(!visited[nx][ny] && board[nx][ny] == 1) {
						queue.offer(new Point(nx, ny, cur.cnt + 1));
						visited[nx][ny] = true;
					}
				}
			}
			
			if(res != 0) break;
		}
	}
}
