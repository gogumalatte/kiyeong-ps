import java.util.*;
import java.io.*;

public class Solution {
	static int N, M, res;
	static List<List<Integer>> graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new FileReader("input창용마을무리의개수.txt"));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			visited = new boolean[N + 1];
			res = 0;
			
			// STEP1. 그래프를 인접 리스트로 표현: 각 정점에서 연결된 다른 정점을 저장
			graph = new ArrayList<>();
			for(int i = 0; i < N + 1; ++i) {
				graph.add(new ArrayList<>());
			}
			
			// STEP2. 간선 정보를 받아 인접 리스트에 저장
			for(int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());
				int temp1 = Integer.parseInt(st.nextToken());
				int temp2 = Integer.parseInt(st.nextToken());
				
				// 무방향 그래프이므로 양쪽에 추가
				graph.get(temp1).add(temp2);
				graph.get(temp2).add(temp1);
			}
			
			// 인접 리스트에 잘 저장되었는지 출력 디버깅
			/*
			for(int i = 0; i <= N; ++i) {
				System.out.print(i + "정점에 연결된 정점:");
				for(int j = 0; j < graph.get(i).size(); ++j) {
					System.out.print(" " + graph.get(i).get(j));
				}
				System.out.println();
			}
			*/
			
			// STEP3. 첫 번째 정점부터 시작해서 DFS or BFS로 방문하며 무리를 확인
			for(int i = 1; i <= N; ++i) {
				if(visited[i]) continue;
				dfs(i);
				res++;
			}
			
			System.out.println("#" + test_case + " " + res);
		}
		br.close();
	}
	
	static void dfs(int v) {
		visited[v] = true;
		
		for(int nextV : graph.get(v)) {
			if(!visited[nextV]) {
				visited[nextV] = true;
				dfs(nextV);
			}
		}
	}
	
	static void bfs(int v) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		
		visited[v] = true;
		queue.offer(v);
		
		while(!queue.isEmpty()) {
			int curV = queue.poll();
			for(int nextV : graph.get(curV)) {
				if(!visited[nextV]) {
					visited[nextV] = true;
					queue.offer(nextV);
				}
			}
		}
	}
}