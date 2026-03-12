import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[][] map;
	static int[][] dist;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static class Pos implements Comparable<Pos> {
		int x, y, cost;
		
		Pos(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pos o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new FileReader("input보급로.txt"));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dist = new int[N][N];
			
			for(int i = 0; i < N; ++i) {
				String s = br.readLine();
				for(int j = 0; j < N; ++j) {
					map[i][j] = s.charAt(j) - '0';
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			int res = solve();
			
			System.out.println("#" + tc + " " + res);
		}
		br.close();
	}
	
	public static int solve() {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		dist[0][0] = 0;
		pq.offer(new Pos(0,0,0));
		
		while(!pq.isEmpty()) {
			Pos cur = pq.poll();
			
			if(cur.x == N - 1 && cur.y == N - 1) {
				return cur.cost;
			}
			
			if(dist[cur.x][cur.y] < cur.cost) continue;
			
			for(int i = 0; i < 4; ++i) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(dist[nx][ny] > dist[cur.x][cur.y] + map[nx][ny]) {
						dist[nx][ny] = dist[cur.x][cur.y] + map[nx][ny];
						pq.offer(new Pos(nx, ny, dist[nx][ny]));
					}
				}
			}
		}
		
		
		return -1;
	}
}
