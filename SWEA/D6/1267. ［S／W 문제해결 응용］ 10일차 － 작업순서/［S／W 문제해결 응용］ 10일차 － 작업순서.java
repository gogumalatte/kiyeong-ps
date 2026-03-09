import java.util.*;
import java.io.*;

public class Solution {
	static int V, E;
	static List<List<Integer>> list;
	static List<Integer> res;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new FileReader("input작업순서.txt"));
		
		int T = 10;
		
		for(int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			res = new ArrayList<>();
			visited = new boolean[V + 1];
			
			for(int i = 0; i <= V; ++i) {
				list.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < E; ++i) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.get(b).add(a); // dfs 기반으로 위상정렬을 하려면 거꾸로 세워주어야 함.
			}
			
			solve();
			
			System.out.print("#" + tc);
			for(int i : res) {
				System.out.print(" " + i);
			}
			System.out.println();
		}
	}
	
	private static void solve() {
		for(int i = 1; i <= V; ++i) {
			dfs(i);
		}
	}
	
	private static void dfs(int v) {
		if(visited[v]) {
			return;
		}
		
		for(Integer i : list.get(v)) {
			if(!visited[i]) {
				dfs(i);
			}
		}
		
		res.add(v);
		visited[v] = true;
	}
}