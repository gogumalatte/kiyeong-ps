import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("bj10709.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int h, w;
		int[][] res;
		char[][] cur;
		
		// step1. 입력받아서 2차원 배열에 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		res = new int[h][w];
		cur = new char[h][w];
		for(int i = 0; i < h; ++i) {
			Arrays.fill(res[i], -1);
		}
		for(int i = 0; i < h; ++i) {
			String line = br.readLine();
			for(int j = 0; j < w; ++j) {
				cur[i][j] = line.charAt(j);
			}
		}
		
		// step2. 현재 자리에서 왼쪽 몇 번째에 구름이 있는지 확인
		for(int i = 0; i < h; ++i) {
			for(int j = 0; j < w; ++j) {
				int cloudIndex = 0;
				while(j - cloudIndex >= 0) {
					if(cur[i][j - cloudIndex] == 'c') {
						break;
					}
					cloudIndex++;
				}
				if(cloudIndex <= j) {
					res[i][j] = cloudIndex;
				}
			}
		}
		
		// step3. 출력
		for(int i = 0; i < h; ++i) {
			for(int j = 0; j < w; ++j) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}
