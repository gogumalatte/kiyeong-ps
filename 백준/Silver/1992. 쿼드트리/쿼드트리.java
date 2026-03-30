import java.io.*;

public class Main {
	static int N;
	static int[][] board;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("bj1992.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for(int i = 0; i < N; ++i) {
			String line = br.readLine();
			for(int j = 0; j < N; ++j) {
				board[i][j] = line.charAt(j) - '0';
			}
		}
		
		sb = new StringBuilder();
		solve(0, 0, N, N);
		
		System.out.println(sb);
	}
	
	private static void solve(int sx, int sy, int fx, int fy) {
		
		// step1. 현재 칸 확인
		int cnt = 0;
		int all = 0;
		for(int y = sy; y < fy; ++y) {
			for(int x = sx; x < fx; ++x) {
				all++;
				if(board[y][x] == 1) cnt++;
			}
		}
		
		// step2. 모든 칸이 0, 혹은 1로만 되어 있으면 0 또는 1 출력
		// step3. 아니라면, 4등분 해서 재귀 호출
		if(cnt == all) sb.append(1);
		else if(cnt == 0) sb.append(0);
		else {
			sb.append("(");
			solve(sx, sy, (sx + fx)/2, (sy + fy)/2);
			solve((sx + fx)/2, sy, fx, (sy + fy)/2);
			solve(sx, (sy + fy)/2, (sx + fx)/2, fy);
			solve((sx + fx)/2, (sy + fy)/2, fx, fy);
			sb.append(")");
		}
	}
}
