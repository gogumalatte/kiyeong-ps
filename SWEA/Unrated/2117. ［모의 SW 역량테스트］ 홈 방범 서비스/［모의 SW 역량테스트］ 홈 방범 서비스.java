import java.util.*;
import java.io.*;

public class Solution {
	private static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M;
	static int[][] board;
	static ArrayList<Point> list;
	static int res;
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int K = N + 1;
			board = new int[N][N];
			list = new ArrayList<>();
			res = 0;
			
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if(board[i][j] == 1) {
						list.add(new Point(i, j));
					}
				}
			}
			
			solve(K);
			
			System.out.println("#" + test_case + " " + res);
		}
		br.close();
	}
	
	private static void solve(int K) {
		if(K == 0) return;
		
		int width = K * K + (K - 1) * (K - 1);
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				// board[i][j]에서 모든 집에 대해 방범 구역에 포함되는 집이 몇 개인지 계산
				// 방범 구역의 크기 <= 방범 구역에 포함되는 집 개수 * M 이면
				// res = 방범 구역에 포함되는 집 개수, return;
				int homeCnt = getIncludedHome(i, j, K);
				if(width <= homeCnt * M) {
					res = Math.max(res, homeCnt);
				}
			}
		}
		
		solve(K - 1);
	}
	
	private static int getIncludedHome(int x, int y, int K) {
		int cnt = 0;
		for(Point point : list) {
			int distance = Math.abs(x - point.x) + Math.abs(y - point.y);
			if(distance < K) cnt++;
		}
		return cnt;
	}
}