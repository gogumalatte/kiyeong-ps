import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int M;
	static int C;
	static int[][] board;
	static int maxProfit;
	static int curProfit;
	
	public static void main(String args[]) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			board = new int[N][N];
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			maxProfit = 0;
			solve();
			System.out.println("#" + test_case + " " + maxProfit);
		}
	}
	
	// 벌통 시작 두 지점을 정함.
	private static void solve() {
		for(int r1 = 0; r1 < N; ++r1) {
			for(int c1 = 0; c1 <= N - M; ++c1) {
				int person1 = getProfitMax(r1, c1);
				
				for(int r2 = 0; r2 < N; ++r2) {
					for(int c2 = 0; c2 <= N - M; ++c2) {
						if(r1 == r2 && c1 + N > c2) continue;
						int person2 = getProfitMax(r2, c2);
						maxProfit = Math.max(maxProfit, person1 + person2);
					}
				}
			}
		}
	}
	
	// 벌통 시작점에서 가로로 연속된 M개의 벌통을 구함.
	private static int getProfitMax(int row, int col) {
		int[] selected = new int[M];
		for(int i = 0; i < M; ++i) {
			selected[i] = board[row][col + i];
		}
		
		curProfit = 0;
		
		calculateSubset(selected, 0, 0, 0);
		
		return curProfit;
	}
	
	private static void calculateSubset(int[] selected, int depth, int sum, int profitSum) {
		if(sum > C) {
			return;
		}
		
		if(depth == M) {
			curProfit = Math.max(curProfit, profitSum);
			return;
		}
		
		calculateSubset(selected, depth + 1, sum + selected[depth], profitSum + selected[depth] * selected[depth]);
		calculateSubset(selected, depth + 1, sum, profitSum);
	}
}
