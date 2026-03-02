import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static double[][] board;
	static int[] seq;
	static boolean[] visited;
	static double result;
	static double cur;
	public static void main(String args[]) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; ++test_case) {
			N = Integer.parseInt(br.readLine());
			board = new double[N][N];
			seq = new int[N];
			visited = new boolean[N];
			result = Double.MIN_VALUE;
			
			for(int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				seq[i] = i;
				for(int j = 0; j < N; ++j) {
					board[i][j] = Double.parseDouble(st.nextToken()) / 100;
				}
			}
			
			solve(0);
			System.out.printf("#%d %.6f\n", test_case, result * 100);
		}
	}
	
	private static void solve(int depth) {
		cur = 1;
		for(int i = 0; i < depth; ++i) {
			cur *= board[i][seq[i]];
		}
		
		if(cur < result) {
			return;
		}
		
		if(depth == N) {
			result = Math.max(result, cur);
			return;
		}
		
		for(int i = 0; i < N; ++i) {
			if(!visited[i]) {
				visited[i] = true;
				seq[depth] = i;
				solve(depth + 1);
				visited[i] = false;
			}
		}
	}
	
	
}
