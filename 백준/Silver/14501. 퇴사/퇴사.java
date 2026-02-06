import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] counselBoard = new int[n][2];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; ++j) {
				counselBoard[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dp = new int[n + 1];

		for (int i = 0; i < n; i++) {
		    // 1. 현재 상담을 건너뛰는 경우 (이전까지의 최댓값을 다음날로 전파)
		    dp[i + 1] = Math.max(dp[i + 1], dp[i]);


		    // 2. 현재 상담을 진행하는 경우
		    int nextDay = i + counselBoard[i][0]; // 상담이 끝나는 시점
		    if (nextDay <= n) {
		        // 기존에 기록된 nextDay의 수익 vs (오늘까지의 수익 + 현재 상담 수익)
		        dp[nextDay] = Math.max(dp[nextDay], dp[i] + counselBoard[i][1]);
		    }
		}
		System.out.println(dp[n]);
	}

}
