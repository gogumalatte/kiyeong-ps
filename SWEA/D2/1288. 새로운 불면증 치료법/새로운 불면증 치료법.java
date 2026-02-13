import java.io.*;
import java.util.*;

public class Solution {
	static int n;
	static boolean isAllCheck;
	static int cur;
	static int[] numCheckBox;
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; ++test_case) {
			n = Integer.parseInt(br.readLine());
			cur = 0;
			isAllCheck = false;
			numCheckBox = new int[10];
			while(isAllCheck == false) {
				cur += n;
				isAllCheck = solve(cur);
			}
			System.out.println("#" + test_case + " " + cur);
		}
	}
	
	private static boolean solve(int cur) {
		boolean isCurCheck = true;
		int temp = cur;
		while(temp != 0) {
			numCheckBox[temp%10]++;
			temp /= 10;
		}
		
		for(int i = 0; i <= 9; ++i) {
			if(numCheckBox[i] == 0) {
				isCurCheck = false;
				break;
			}
		}
		
		return isCurCheck;
	}
}