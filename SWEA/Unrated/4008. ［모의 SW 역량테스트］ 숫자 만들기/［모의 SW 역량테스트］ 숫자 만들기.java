import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static int[] operator = new int[4]; // +, -, *, /
	static int[] operand;
	static int maxRes;
	static int minRes;
	static ArrayList<Integer> list = new ArrayList<>();;
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; ++test_case) {
			n = Integer.parseInt(br.readLine());
			maxRes = Integer.MIN_VALUE;
			minRes = Integer.MAX_VALUE;
			list.clear();
			operand = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; ++i) {
				operator[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) {
				operand[i] = Integer.parseInt(st.nextToken());
			}
			
			solve(0);
			System.out.println("#" + test_case + " " + (maxRes - minRes));
		}
	}
	
	private static void solve(int depth) {
		if(depth == n - 1) {
			calc();
			return;
		}
		
		for(int j = 0; j < 4; ++j) {
			if(operator[j] > 0) {
				operator[j]--;
				list.add(j);
				solve(depth+1);
				list.remove(list.size() - 1);
				operator[j]++;
				
			}
		}
	}
	
	private static void calc() {
		int cur = operand[0];
		int index = 1;
		for(Integer i : list) {
			if(i == 0) cur += operand[index++];
			else if(i == 1) cur -= operand[index++];
			else if(i == 2) cur *= operand[index++];
			else if(i == 3) cur /= operand[index++];
		}
		maxRes = Math.max(maxRes, cur);
		minRes = Math.min(minRes, cur);
	}
}