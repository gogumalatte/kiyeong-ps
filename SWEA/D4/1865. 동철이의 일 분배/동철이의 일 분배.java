import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static double[][] board;
	static boolean[] visited;
	static double result;
    
	public static void main(String args[]) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; ++test_case) {
			N = Integer.parseInt(br.readLine());
			board = new double[N][N];
			visited = new boolean[N];
			result = Double.MIN_VALUE;
			
			for(int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					board[i][j] = Double.parseDouble(st.nextToken()) / 100;
				}
			}
			
			solve(0, 1.0);
			System.out.printf("#%d %.6f\n", test_case, result * 100);
		}
	}
	
	private static void solve(int depth, double cur) {
		
		if(cur <= result) {
			return;
		}
		
		if(depth == N) {
			result = Math.max(result, cur);
			return;
		}
		
		for(int i = 0; i < N; ++i) {
			if(!visited[i]) {
                if(board[depth][i] == 0) continue;
				visited[i] = true;
				solve(depth + 1, cur * board[depth][i]);
				visited[i] = false;
			}
		}
	}
	
	
}
