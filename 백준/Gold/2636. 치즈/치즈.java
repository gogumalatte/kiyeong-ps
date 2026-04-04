import java.util.*;
import java.io.*;

public class Main {
	static int M, N;
	static int[][] map;
	static int totalCheese = 0;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("bj2636.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		
		
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					totalCheese++;
				}
			}
		}
		int lastCheese = totalCheese;
		int time = 0;
		
		while(totalCheese > 0) {
			lastCheese = totalCheese;
			removeOutline();
			time++;
		}
		
		System.out.println(time);
		System.out.println(lastCheese);
	}
	
	private static void removeOutline() {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[M][N];
		
		queue.offer(new int[] {0, 0});
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			
			for(int i = 0; i < 4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny]) {
					visited[nx][ny] = true;
					
					if(map[nx][ny] == 0) {
						queue.offer(new int[] {nx, ny});
					} else if(map[nx][ny] == 1) {
						map[nx][ny] = 0;
						totalCheese--;
					}
				}
			}
		}
	}
}
