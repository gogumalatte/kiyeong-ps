import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int test_case = 1; test_case <= T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int startV = Integer.parseInt(st.nextToken());
			boolean[][] contacts = new boolean[101][101]; // 방향 그래프를 2차원 배열로 표현
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n/2; ++i) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				contacts[from][to] = true;
			}
			
			/* 변수 선언 */
			boolean[] visited = new boolean[101]; // 방문 했는지 여부
			int[] floor = new int[101]; // 각 정점이 몇 번째 연락에 방문하는지
			int maxFloor = 0; // 정점들 중 젤 늦게 방문한 횟수
			Queue<Integer> queue = new ArrayDeque<>();
			queue.offer(startV);
			visited[startV] = true;
			
			/* bfs로 방문 */
			while(!queue.isEmpty()) {
				int curV = queue.poll();
				
				for(int next = 1; next <= 100; ++next) {
					if(contacts[curV][next] && !visited[next]) {
						queue.offer(next);
						visited[next] = true;
						floor[next] = floor[curV] + 1;
						maxFloor = Math.max(maxFloor, floor[next]);
					}
				}
			}

			/* 가장 늦게 연락 받은 사람들 중 번호가 가장 큰 사람 출력 */
			for(int i = 100; i >= 0; --i) {
				if(floor[i] == maxFloor) {
					System.out.println("#" + test_case + " " + i);
					break;
				}
			}
		}
	}
}