import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] board;
	static boolean[] visited;
	static int res = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0, 0);
		System.out.println(res);
	}
	
	private static void combination(int start, int depth) {
		
		if(depth == N/2) {
			calcDiff();
			return;
		}
		
		for(int i = start; i < N; ++i) {
			if(!visited[i]) {
				visited[i] = true;
				combination(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}
	
	private static void calcDiff() {
		int startTeamTotal = 0;
		int linkTeamTotal = 0;
		
		for(int i = 0; i < N; ++i) {
			for(int j = i + 1; j < N; ++j) {
				if(visited[i] && visited[j]) {
					startTeamTotal += board[i][j];
					startTeamTotal += board[j][i];
				} else if(!visited[i] && !visited[j]) {
					linkTeamTotal += board[i][j];
					linkTeamTotal += board[j][i];
				}
			}
		}
		
		int diff = Math.abs(startTeamTotal - linkTeamTotal);
		
		if(diff == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		res = Math.min(res, diff);
	}
}
