import java.util.*;
import java.io.*;

public class Solution {
	static int V, E;
	static List<List<Integer>> adj;
	static int[] inDegree; // 진입 차수 저장
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new FileReader("input작업순서.txt"));
		
		int T = 10;
		
		for(int tc = 1; tc <= 10; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList<>();
			inDegree = new int[V + 1];
			for(int i = 0; i <= V; ++i) adj.add(new ArrayList<>());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < E; ++i) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj.get(from).add(to);
				inDegree[to]++;
			}
			
			sb = new StringBuilder();
			sb.append("#").append(tc);
			kahnSolve();
			System.out.println(sb.toString());
		}
	}
	
	private static void kahnSolve() {
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i = 1; i <= V; ++i) {
			if(inDegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(" ").append(cur);
			
			for(int next : adj.get(cur)) {
				inDegree[next]--;
				
				if(inDegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
	}
}