import java.util.*;
import java.io.*;

public class Main {
	static int N, C;
	static Map<Integer, Integer> map;
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("bj2910.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// step1. HashMap에 저장
		map = new LinkedHashMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		// step2. 정렬
		List<Integer> list = new ArrayList<>(map.keySet());
		list.sort((a, b) -> {
			int freqA = map.get(a);
			int freqB = map.get(b);
			
			return Integer.compare(freqB, freqA);
		});

		// step3. 출력
		for(Integer i : list) {
			for(int j = 0; j < map.get(i); ++j) {
				System.out.print(i + " ");
			}
		}
	}
}