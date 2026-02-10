import java.util.*;
import java.io.*;

class Vertex {
	int x, y;
	Vertex(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static ArrayList<Vertex> house = new ArrayList<>();
	static ArrayList<Vertex> chicken = new ArrayList<>();
	static ArrayList<Integer> comb = new ArrayList<>();
	static int n;
	static int m;
	static int res;
	
	
	public static void main (String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		res = Integer.MAX_VALUE;
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				int val = Integer.parseInt(st.nextToken());
				if(val == 1) {
					Vertex v = new Vertex(i, j);
					house.add(v);
				}
				if(val == 2) {
					Vertex v = new Vertex(i, j);
					chicken.add(v);
				}
			}
		}
		
		combination(0,0);
		System.out.println(res);
	}
	
	// step1. 치킨 가게 중 m개 만큼 조합
	static void combination(int start, int depth) {
		if(depth == m) {
			// 완성된 조합에 대해 연산 실행
			int curChickenDistance = 0;
			for(Vertex i : house) {
				int houseToChickenMinDistance = Integer.MAX_VALUE;
				for(Integer j : comb) {
					int houseToChickenDistance = Math.abs(i.x - chicken.get(j).x) + Math.abs(i.y - chicken.get(j).y);
					houseToChickenMinDistance = Math.min(houseToChickenMinDistance, houseToChickenDistance);
				}
				curChickenDistance += houseToChickenMinDistance;
			}
			res = Math.min(res, curChickenDistance);
			return;
		}
		
		for(int i = start; i < chicken.size(); ++i) {
			comb.add(i);
			combination(i + 1, depth + 1);
			comb.remove(comb.size()-1);
		}
	}
}