import java.io.*;
import java.util.*;

public class Main {
	static int L, C;
	static char[] arr;
	static char[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		result = new char[L];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; ++i) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		
		solve(0, 0);
		System.out.print(sb);
		br.close();
	}
	
	private static void solve(int start, int depth) {
		if(depth == L) {
			if(isValid()) {
				sb.append(new String(result)).append('\n');
			}
			return;
		}
		
		for(int i = start; i < C; ++i) {
			result[depth] = arr[i];
			solve(i + 1, depth + 1);
			
		}
	}
	
	private static boolean isValid() {
		int vowel = 0;
		int consonant = 0;
		
		for(int i = 0; i < L; ++i) {
			if(result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u') {
				vowel++;;
			} else {
				consonant++;
			}
		}
		
		return vowel >= 1 && consonant >= 2;
	}
}
