import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int M;
	static int[][] board = {
			{3, 2, 1, 1},
			{2, 2, 2, 1},
			{2, 1, 2, 2},
			{1, 4, 1, 1},
			{1, 1, 3, 2},
			{1, 2, 3, 1},
			{1, 1, 1, 4},
			{1, 3, 1, 2},
			{1, 2, 1, 3},
			{3, 1, 1, 2}
	};
	static int[][] arr;
	static int[] statement;
	static int res;
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			res = 0;
			
			for(int i = 0; i < N; ++i) {
				String s = br.readLine();
				char[] charArray = s.toCharArray();
				for(int j = 0; j < M; ++j) {
					arr[i][j] = (int) (charArray[j] - '0');
				}
			}
			
			solve();
			System.out.println("#" + test_case + " " + res);
		}
		
		br.close();
	}
	
	private static void solve() {
		int rowIndex = 0;
		int colIndex = 0;
		statement = new int[56];
		
		// 암호코드 시작 자리 찾기
		for(int i = 0; i < N; ++i) {
			if(rowIndex != 0) break;
			for(int j = M - 1; j >= 0; --j) {
				if(arr[i][j] == 1) {
					rowIndex = i;
					colIndex = j - 55;
					break;
				}
			}
		}
		
		// 암호문 추출
		for(int i = 0; i < 56; ++i) {
			statement[i] = arr[rowIndex][i + colIndex];
		}
		
		// 추출한 암호문이 정상 암호코드 인지 확인, 정상이라면 암호 코드 숫자 합 반환, 아니라면 0 반환
		res = checkcheck(statement);
	}
	
	private static int checkcheck(int[] statement) {
		int cur = 0;
		int sum = 0;
		int[] intStatement = new int[8];
		for(int i = 0; i < 8; ++i) {
			int[] temp = new int[4];
			int index = 0;
			
			// 암호문을 평문 숫자로 복호화
			for(int j = 0; j < 7; ++j) {
				if(j == 0) {
					temp[0] = 1;
					continue;
				}
				
				if(statement[i * 7 + j - 1] == statement[i * 7 + j]) {
					temp[index]++;
				} else {
					index += 1;
					temp[index]++;
				}
			}
			
			for(int j = 0; j < 10; ++j) {
				if(temp[0] == board[j][0] && temp[1] == board[j][1] && temp[2] == board[j][2] && temp[3] == board[j][3]) {
					intStatement[i] = j;
					break;
				}
			}
		}
		
		// 암호코드가 정상이라면 숫자 합 반환, 아니라면 0 반환
		for(int i = 0; i < 8; ++i) {
			
			if(i % 2 == 0) {
				sum += (intStatement[i] * 3);
			} else {
				sum += intStatement[i];
			}
			cur += intStatement[i];
		}
		
		if(sum % 10 == 0) {
			return cur;
		}
		
		return 0;
	}
}
