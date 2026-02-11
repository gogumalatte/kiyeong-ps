import java.util.*;
import java.io.*;

public class Main {
	static int[][] board;
	static int n;
	static int m;
	static int res;
	
	public static void main (String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		res = 0;
		
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve();
		System.out.println(res);
	}
	private static void solve() {
		Tetro_type1();
		Tetro_type2();
		Tetro_type3();
		Tetro_type4();
		Tetro_type5();
	}
	
	private static void Tetro_type1() {
		// 가로로 누워 있는 모양
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j <= m - 4; ++j) {
				int cur = board[i][j] + board[i][j+1] + board[i][j+2] + board[i][j+3];
				res = Math.max(res, cur);
			}
		}
		// 세로로 서 있는 모양
		for(int i = 0; i <= n - 4; ++i) {
			for(int j = 0; j < m; ++j) {
				int cur = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+3][j];
				res = Math.max(res, cur);
			}
		}
	}
	
	private static void Tetro_type2() {
		// 네모 모양
		for(int i = 0; i <= n - 2; ++i) {
			for(int j = 0; j <= m - 2; ++j) {
				int cur = board[i][j] + board[i+1][j] + board[i][j+1] + board[i+1][j+1];
				res = Math.max(res, cur);
			}
		}
	}
	
	private static void Tetro_type3() {
		// 가로 두 줄 왼쪽 위로 뾰족
		for(int i = 0; i <= n - 3; ++i) {
			for(int j = 0; j <= m - 2; ++j) {
				int cur = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+2][j+1];
				res = Math.max(res, cur);
			}
		}
		// 가로 두 줄 왼쪽 아래로 뾰족
		for(int i = 0; i <= n - 3; ++i) {
			for(int j = 0; j <= m - 2; ++j) {
				int cur = board[i][j] + board[i][j+1] + board[i+1][j] + board[i+2][j];
				res = Math.max(res, cur);
			}
		}
		// 가로 두 줄 오른쪽 위로 뾰족
		for(int i = 0; i <= n - 3; ++i) {
			for(int j = 0; j <= m - 2; ++j) {
				int cur = board[i][j+1] + board[i+1][j+1] + board[i+2][j+1] + board[i+2][j];
				res = Math.max(res, cur);
			}
		}
		// 가로 두 줄 오른쪽 아래로 뾰족
		for(int i = 0; i <= n - 3; ++i) {
			for(int j = 0; j <= m - 2; ++j) {
				int cur = board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+2][j+1];
				res = Math.max(res, cur);
			}
		}
		// 가로 3줄 왼쪽 위로 뾰족
		for(int i = 0; i <= n - 2; ++i) {
			for(int j = 0; j <= m - 3; ++j) {
				int cur = board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+1][j+2];
				res = Math.max(res, cur);
			}
		}
		// 가로 3줄 왼쪽 아래로 뾰족
		for(int i = 0; i <= n - 2; ++i) {
			for(int j = 0; j <= m-3; ++j) {
				int cur = board[i][j] + board[i+1][j] + board[i][j+1] + board[i][j+2];
				res = Math.max(res, cur);
			}
		}
		// 가로 3줄 오른쪽 위로 뾰족
		for(int i = 0; i <= n - 2; ++i) {
			for(int j = 0; j <= m - 3; ++j) {
				int cur = board[i][j+2] + board[i+1][j] + board[i+1][j+1] + board[i+1][j+2];
				res = Math.max(res, cur);
			}
		}
		// 가로 3줄 오른쪽 아래로 뾰족
		for(int i = 0; i <= n - 2; ++i) {
			for(int j = 0; j <= m - 3; ++j) {
				int cur = board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j+2];
				res = Math.max(res, cur);
			}
		}
		
	}
	
	private static void Tetro_type4() {
		for(int i = 0; i <= n - 3; ++i) {
			for(int j = 0; j <= m - 2; ++j) {
				int cur = board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+2][j+1];
				res = Math.max(res, cur);
			}
		}
		for(int i = 0; i <= n - 3; ++i) {
			for(int j = 0; j <= m - 2; ++j) {
				int cur = board[i+1][j] + board[i+2][j] + board[i][j+1] + board[i+1][j+1];
				res = Math.max(res, cur);
			}
		}
		for(int i = 0; i <= n - 2; ++i) {
			for(int j = 0; j <= m - 3; ++j) {
				int cur = board[i][j+1] + board[i][j+2] + board[i+1][j] + board[i+1][j+1];
				res = Math.max(res, cur);
			}
		}
		for(int i = 0; i <= n - 2; ++i) {
			for(int j = 0; j <= m - 3; ++j) {
				int cur = board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+1][j+2];
				res = Math.max(res, cur);
			}
		}
	}
	
	private static void Tetro_type5() {
		// ㅏ 모양
		for(int i = 0; i <= n - 3; ++i) {
			for(int j = 0; j <= m - 2; ++j) {
				int cur = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+1][j+1];
				res = Math.max(res, cur);
			}
		}
		// ㅓ 모양
		for(int i = 0; i <= n - 3; ++i) {
			for(int j = 0; j <= m - 2; ++j) {
				int cur = board[i][j+1] + board[i+1][j+1] + board[i+2][j+1] + board[i+1][j];
				res = Math.max(res, cur);
			}
		}
		// ㅗ 모양
		for(int i = 0; i <= n - 2; ++i) {
			for(int j = 0; j <= m - 3; ++j) {
				int cur = board[i+1][j] + board[i+1][j+1] + board[i+1][j+2] + board[i][j+1];
				res = Math.max(res, cur);
			}
		}
		// ㅜ 모양
		for(int i = 0; i <= n - 2; ++i) {
			for(int j = 0; j <= m - 3; ++j) {
				int cur = board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j+1];
				res = Math.max(res, cur);
			}
		}
	}
}
