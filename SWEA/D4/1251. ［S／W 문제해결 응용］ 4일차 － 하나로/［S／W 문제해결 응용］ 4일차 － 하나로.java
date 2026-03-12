import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[] x;
	static int[] y;
	static long[][] graph;
	static double totalSum;
	static int totalCnt;
	
	static class Edge implements Comparable<Edge> {
		int target;
		long weight;
		
		Edge(int target, long weight) {
			this.target = target;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new FileReader("input하나로.txt"));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			x = new int[N];
			y = new int[N];
			graph = new long[N][N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; ++i) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; ++i) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			double E = Double.parseDouble(br.readLine());
			for(int i = 0; i < N - 1; ++i) {
				for(int j = i + 1; j < N; ++j) {
					long dx = x[i] - x[j];
					long dy = y[i] - y[j];
					graph[i][j] = dx * dx + dy * dy;
					graph[j][i] = graph[i][j];
				}
			}
			totalSum = 0;
			totalCnt = 0;
			
			prim();
			
			System.out.println("#" + tc + " " + Math.round(E * totalSum));
		}
	}
	
	public static void prim() {
		boolean[] visited = new boolean[N];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0, 0));
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int curTarget = edge.target;
			
			if(visited[curTarget]) continue;
			
			visited[curTarget] = true;
			totalSum += edge.weight;
			totalCnt++;
			
			if(totalCnt == N) break;
			
			for(int next = 0; next < N; ++next) {
				if(graph[curTarget][next] != 0 && !visited[next]) {
					pq.offer(new Edge(next, graph[curTarget][next]));
				}
			}
		}
	}
}
