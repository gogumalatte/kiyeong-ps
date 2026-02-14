import java.io.*;

class Main {
	static long[][] basic = {{1, 1}, {1, 0}};
	static long mod = 1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		
		long[][] res = solve(n);
		System.out.println(res[0][1]);
	}
	
	private static long[][] solve(long n) {
		if(n == 1) {
			return basic;
		}
		
		if(n % 2 == 0) {
			return calc(solve(n/2), false);
		} else {
			return calc(solve(n/2), true);
		}
	}
	
	private static long[][] calc(long[][] matrix, boolean isOdd) {
		long newMatrix[][] = new long[2][2];
		newMatrix[0][0] = ((matrix[0][0] * matrix[0][0]) % mod + (matrix[0][1] * matrix[1][0]) % mod) % mod;
		newMatrix[0][1] = ((matrix[0][0] * matrix[0][1]) % mod + (matrix[0][1] * matrix[1][1]) % mod) % mod;
		newMatrix[1][0] = ((matrix[1][0] * matrix[0][0]) % mod + (matrix[1][1] * matrix[1][0]) % mod) % mod;
		newMatrix[1][1] = ((matrix[1][0] * matrix[0][1]) % mod + (matrix[1][1] * matrix[1][1]) % mod) % mod;
		
		if(isOdd) {
			long a, b, c, d;
			a = ((newMatrix[0][0] * basic[0][0]) % mod + (newMatrix[0][1] * basic[1][0]) % mod) % mod;
			b = ((newMatrix[0][0] * basic[0][1]) % mod + (newMatrix[0][1] * basic[1][1]) % mod) % mod;
			c = ((newMatrix[1][0] * basic[0][0]) % mod + (newMatrix[1][1] * basic[1][0]) % mod) % mod;
			d = ((newMatrix[1][0] * basic[0][1]) % mod + (newMatrix[1][1] * basic[1][1]) % mod) % mod;
			newMatrix[0][0] = a;
			newMatrix[0][1] = b;
			newMatrix[1][0] = c;
			newMatrix[1][1] = d;
		}
		
		return newMatrix;
	}
}
