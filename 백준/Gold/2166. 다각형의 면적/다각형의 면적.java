import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] arr = new long[N+1][2];
		long calcRight = 0;
		long calcLeft = 0;
		double answer = 0;
		int index = 0;
		for(; index < N; ++index) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[index][0] = Integer.parseInt(st.nextToken());
			arr[index][1] = Integer.parseInt(st.nextToken());
		}
		arr[index][0] = arr[0][0];
		arr[index][1] = arr[0][1];
		
		for(int i = 0; i < N; ++i) {
			calcRight += arr[i][0] * arr[i+1][1];
		}
		for(int i = 0; i < N; ++i) {
			calcLeft += arr[i][1] * arr[i+1][0];
		}
		answer = Math.abs(calcRight - calcLeft) / 2.0;
		System.out.printf("%.1f\n", answer);
	}
}
