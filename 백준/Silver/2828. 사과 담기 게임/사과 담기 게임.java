import java.util.*;
import java.io.*;

public class Main {
	static int N, M, J;
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("bj2828.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());		
		J = Integer.parseInt(br.readLine());
		
		int head = 1;
		int trail = M;
		int dist = 0;
		
		for(int i = 0; i < J; ++i) {
			int apple = Integer.parseInt(br.readLine());
			
			if(head <= apple && apple <= trail) {
				continue;
			} else if(trail < apple) {
				dist += (apple - trail);
				head += (apple - trail);
				trail = apple;
			} else {
				dist += (head - apple);
				trail -= (head - apple);
                head = apple;
			}
		}
		
		System.out.println(dist);
		
	}
}
