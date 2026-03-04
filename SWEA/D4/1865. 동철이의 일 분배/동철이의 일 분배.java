import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static double[][] board;
	static boolean[] visited;
	static double res;
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; ++test_case) {
			N = Integer.parseInt(br.readLine());
			board = new double[N][N];
			visited = new boolean[N];
			res = Double.MIN_VALUE;
			
			for(int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					board[i][j] = Double.parseDouble(st.nextToken()) / 100;
				}
			}
			
			solve(0, 1);
			System.out.printf("#%d %.6f\n", test_case, res * 100);
		}
	}
	
	private static void solve(int depth, double cur) {
		// 종료 조건1. 현재 확률이 전역 변수로 저장된 가장 큰 확률보다 작거나 같을 때 (더 이상 커질 수 없기 때문: 확률 <= 1) 
		if(cur <= res) {
			return;
		}
		
		// 종료 조건2. 종료 조건 1에 해당하지 않고 모든 순서가 다 정해진다면 그 값은 최대 확률임.
		if(depth == N) {
			res = cur;
			return;
		}
		
		for(int i = 0; i < N; ++i) {
			if(!visited[i]) {
				visited[i] = true;
				solve(depth + 1, cur * board[depth][i]);
				visited[i] = false;
			}
		}
	}
}
