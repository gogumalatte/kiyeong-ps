import java.util.*;
import java.io.*;

public class Main {
	static class Point{
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M, K;
	static int[][] board;
	static boolean[][] visited;
	static int res;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("bj1012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			res = 0;
			board = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i = 0; i < K; ++i) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				board[y][x] = 1;
			}
			
			bfs();
			
			System.out.println(res);
		}
	}
	
	private static void bfs() {
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(board[i][j] == 1 && !visited[i][j]) {
					res++;
					ArrayDeque<Point> queue = new ArrayDeque<>();
					queue.offer(new Point(i, j));
					
					while(!queue.isEmpty()) {
						Point cur = queue.poll();
						
						for(int dir = 0; dir < 4; ++dir) {
							int nx = cur.x + dx[dir];
							int ny = cur.y + dy[dir];
							
							if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
								if(board[nx][ny] == 1 && !visited[nx][ny]) {
									visited[nx][ny] = true;
									queue.offer(new Point(nx, ny));
								}
							}
						}
					}
				}
			}
		}
	}
}
