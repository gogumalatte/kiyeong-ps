import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("bj4659.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			String line = br.readLine();
			
			if(line.equals("end")) break;
			
			char[] pw = line.toCharArray();
			
			boolean rule1 = false, rule2 = true, rule3 = true;
			
			for(int i = 0; i < pw.length; ++i) {
				if(pw[i] == 'a' || pw[i] == 'e' || pw[i] == 'i' || pw[i] == 'o' || pw[i] == 'u') {
					rule1 = true;
				}
				
				if(i >= 1) {
					if(pw[i - 1] == pw[i] && pw[i] != 'e' && pw[i] != 'o') {
						rule2 = false;
						break;
					}
				}
				
				if(i >= 2) {
					int cnt = 0;
					if(pw[i - 2] == 'a' || pw[i - 2] == 'e' || pw[i - 2] == 'i' || pw[i - 2] == 'o' || pw[i - 2] == 'u') {
						cnt++;
					}
					if(pw[i - 1] == 'a' || pw[i - 1] == 'e' || pw[i - 1] == 'i' || pw[i - 1] == 'o' || pw[i - 1] == 'u') {
						cnt++;
					}
					if(pw[i] == 'a' || pw[i] == 'e' || pw[i] == 'i' || pw[i] == 'o' || pw[i] == 'u') {
						cnt++;
					}
					if(cnt == 3 || cnt == 0) {
						rule3 = false;
						break;
					}
				}
			}
			
			if(rule1 && rule2 && rule3) {
				System.out.println("<" + line + ">" + " is acceptable.");
			} else {
				System.out.println("<" + line + ">" + " is not acceptable.");
			}
		} while(true);
	}
}
