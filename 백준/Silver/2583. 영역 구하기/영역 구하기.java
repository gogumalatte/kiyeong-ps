import java.util.*;
import java.io.*;

public class Main {
	static int M, N, K;
	static int[][] board;
	static boolean[][] visited;
	static ArrayList<Integer> res = new ArrayList<>();;
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
		// BufferedReader br = new BufferedReader(new FileReader("bj2583.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			int finish_x = Integer.parseInt(st.nextToken());
			int finish_y = Integer.parseInt(st.nextToken());
			
			for(int y = start_y; y < finish_y; ++y) {
				for(int x = start_x; x < finish_x; ++x) {
					board[y][x] = 1;
				}
			}
		}
		
		solve();
		
		res.sort(null);
		
		System.out.println(res.size());
		for(Integer i : res) {
			System.out.print(i + " ");
		}
	}
	
	private static void solve() {
		for(int i = 0; i < M; ++i) {
			for(int j = 0; j < N; ++j) {
				if(board[i][j] == 0 && !visited[i][j]) {
					int cnt = 1;
					ArrayDeque<Point> queue = new ArrayDeque<>();
					queue.offer(new Point(j, i));
					visited[i][j] = true;
					
					while(!queue.isEmpty()) {
						Point cur = queue.poll();
						
						for(int dir = 0; dir < 4; ++dir) {
							int nx = cur.x + dx[dir];
							int ny = cur.y + dy[dir];
							
							if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
								if(board[ny][nx] == 0 && !visited[ny][nx]) {
									queue.offer(new Point(nx, ny));
									visited[ny][nx] = true;
									cnt++;
								}
							}
						}
					}
					
					res.add(cnt);
				}
			}
		}
	}
}
