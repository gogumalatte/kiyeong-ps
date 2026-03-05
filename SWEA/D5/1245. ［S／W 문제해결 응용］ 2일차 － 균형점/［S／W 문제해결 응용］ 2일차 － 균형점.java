import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static double[] positions;
	static int[] weights;
	static double[] res;
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input균형점.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; ++test_case) {
			N = Integer.parseInt(br.readLine());
			positions = new double[N];
			weights = new int[N];
			res = new double[N - 1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; ++i) {
				positions[i] = Double.parseDouble(st.nextToken());
			}
			for(int i = 0; i < N; ++i) {
				weights[i] = Integer.parseInt(st.nextToken());
			}
			
			solve();
			
			System.out.print("#" + test_case);
			for(double i : res) {
				System.out.printf(" %.10f", i);
			}
			System.out.println();
		}
	}
	
	private static void solve() {
		for(int i = 1; i < N; ++i) {
			getBalancePoint(i, positions[i - 1], positions[i]);
		}
	}
	
	private static void getBalancePoint(int index, double start, double end) {
		double low = start;
	    double high = end;
	    double mid = 0;

	    for (int k = 0; k < 100; k++) {
	        mid = (low + high) / 2.0;
	        double fLeft = 0;
	        double fRight = 0;

	        for (int i = 0; i < N; i++) {
	            double distanceSq = Math.pow(positions[i] - mid, 2);
	            double force = weights[i] / distanceSq;

	            if (positions[i] < mid) fLeft += force;
	            else fRight += force;
	        }

	        // 왼쪽 힘이 더 강하면 균형점은 더 high 쪽에 있어야 함
	        if (fLeft > fRight) low = mid;
	        else high = mid;
	    }
	    res[index - 1] = mid;
	}
}
