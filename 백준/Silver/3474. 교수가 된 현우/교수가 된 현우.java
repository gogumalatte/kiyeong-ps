import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("bj3474.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; ++tc) {
			int num = Integer.parseInt(br.readLine());
			int divNum = 5;
			int res = 0;
			List<Integer> list = new ArrayList<>();
			while(divNum <= num) {
				list.add(num / divNum);
				divNum *= 5;
			}
			
			for(Integer i : list) {
				res += i;
			}
			
			System.out.println(res);
		}
	}
}
