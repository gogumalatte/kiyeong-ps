
import java.util.*;
import java.io.*;

public class Main {
	static int mod = 1000000;
	static int period = 15*(mod/10);
	static int[] pibo = new int[period];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		pibo[0] = 0;
		pibo[1] = 1;
		for(int i = 2; i < period; ++i) {
			pibo[i] = ((pibo[i-1] % mod) + (pibo[i-2] % mod)) % mod;
		}
		
		System.out.println(pibo[(int)(n % period)]);
	}
}
