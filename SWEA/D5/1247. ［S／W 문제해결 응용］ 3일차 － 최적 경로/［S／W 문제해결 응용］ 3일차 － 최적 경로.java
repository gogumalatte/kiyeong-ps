import java.util.*;
import java.io.*;

class Point {
	int x,y;
}

public class Solution {
	static int N;
	static Point home;
	static Point office;
	static Point[] customer;
	static int res;
	static boolean[] visited;
	static int[] sequence;
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; ++test_case) {
			N = Integer.parseInt(br.readLine());
			office = new Point();
			home = new Point();
			customer = new Point[N];
			res = Integer.MAX_VALUE;
			visited = new boolean[N];
			sequence = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			office.x = Integer.parseInt(st.nextToken());
			office.y = Integer.parseInt(st.nextToken());
			home.x = Integer.parseInt(st.nextToken());
			home.y = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < N; ++i) {
				customer[i] = new Point();
				customer[i].x = Integer.parseInt(st.nextToken());
				customer[i].y = Integer.parseInt(st.nextToken());
			}
			
			solve(0, 0);
			System.out.println("#" + test_case + " " + res);
		}
	}
	
	private static void solve(int depth, int cur) {
		
		// 종료 조건 1. 계산 중인 경로가 저장된 최소 경로보다 길다면 가지치기.
		if(cur >= res) {
			return;
		}
		
		if(depth == N) {
			// 마지막 지점 to 집까지 거리 합산
			// 최소이면 res 초기화
			res = Math.min(res, cur + Math.abs(home.x - customer[sequence[depth - 1]].x) + Math.abs(home.y - customer[sequence[depth -1]].y));
			return;
		}
		
		for(int i = 0; i < N; ++i) {
			if(!visited[i]) {
				visited[i] = true;
				sequence[depth] = i;
				// 첫 번째 지점이면 office to 첫 번째까지 거리
				// 아니라면 이전 지점 to 현재 지점
				if(depth == 0) {
					solve(depth + 1, cur + Math.abs(office.x - customer[sequence[depth]].x) + Math.abs(office.y - customer[sequence[depth]].y));
				} else {
					solve(depth + 1, cur + Math.abs(customer[i].x - customer[sequence[depth - 1]].x) + Math.abs(customer[i].y - customer[sequence[depth - 1]].y));
				}
				visited[i] = false;
			}
		}
	}
}