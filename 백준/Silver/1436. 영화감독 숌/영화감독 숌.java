import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("bj1436.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int num = 666;
		
		while(true) {
			int temp = num;
			
			while(temp >= 666) {
				if(temp % 1000 == 666) {
					cnt++;
					break;
				}
				temp /= 10;
			}
			
			if(cnt == n) {
				System.out.println(num);
				break;
			}
			
			num++;
		}
	}
}
