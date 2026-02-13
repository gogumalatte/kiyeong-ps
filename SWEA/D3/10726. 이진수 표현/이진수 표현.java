import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static int m;
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[30]; // 이진수를 담을 배열
			boolean check = true;
			
			// step1. 마지막 n자리만 배열에 담기.
			int index = 0;
			while(m != 0 || index < n) {
				arr[index++] = m % 2;
				m /= 2;
			}
			
			for(int i = 0; i < n; ++i) {
				if(arr[i] == 0) {
					check = false;
					break;
				}
			}
			
			if(check) System.out.println("#" + test_case + " ON");
			else System.out.println("#" + test_case + " OFF");
		}
	}
}