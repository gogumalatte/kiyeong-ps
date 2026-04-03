import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("bj2870.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i < M; ++i) {
			String line = br.readLine();
			
			for(int j = 0; j < line.length(); ++j) {
				if(line.charAt(j) >= '0' && line.charAt(j) <= '9') {
					int startIndex = j;
					while(j < line.length() && line.charAt(j) >= '0' && line.charAt(j) <= '9') {
						j++;
					}
					int endIndex = j;
					String newNum = line.substring(startIndex, endIndex);
					// BigInteger bigNum = new BigInteger(newNum);
					// list.add(bigNum.toString());
					int zeroIndex = 0;
					while(zeroIndex < newNum.length() && newNum.charAt(zeroIndex) == '0') {
						zeroIndex++;
     				}
					if(zeroIndex == newNum.length()) {
						list.add("0");
					} else {
						list.add(newNum.substring(zeroIndex));
					}
				}
			}
		}
		
		list.sort((a, b) -> {
			if(a.length() == b.length()) {
				return a.compareTo(b);
			}
			
			return Integer.compare(a.length(), b.length());
		});
		
		for(String s : list) {
			System.out.println(s);
		}
	}
}
