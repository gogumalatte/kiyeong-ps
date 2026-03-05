import java.util.*;
import java.io.*;

public class Solution {
	static int[] list;
	static int N;
	static int res;
	static HashSet<Integer>[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new FileReader("input최대상금.txt"));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			N = Integer.parseInt(st.nextToken());
			res = 0;
			list = new int[s.length()];
			visited = new HashSet[N + 1];
			for(int i = 0; i <= N; ++i) visited[i] = new HashSet<>();
			
			for(int i = 0; i < s.length(); ++i) {
				list[i] = s.charAt(i) - '0';
			}
			
			solve(0);
			System.out.println("#" + test_case + " " + res);
		}
		br.close();
	}
	
	private static void solve(int depth) {
		int cur = arrayToInt();
		
		if(visited[depth].contains(cur)) return;
		visited[depth].add(cur);
		
		if(depth == N) {
			res = Math.max(res, cur);
			return;
		}
		
		for(int i = 0; i < list.length; ++i) {
			for(int j = i + 1; j < list.length; ++j) {
				swap(i, j);
				solve(depth + 1);
				swap(i, j);
			}
		}
	}
	
	private static void swap(int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	private static int arrayToInt( ) {
		int cur = 0;
		int temp = 1;
		for(int i = 0; i < list.length; ++i) {
			cur += temp * list[list.length - 1 -i];
			temp *= 10;
		}
		
		return cur;
	}
}