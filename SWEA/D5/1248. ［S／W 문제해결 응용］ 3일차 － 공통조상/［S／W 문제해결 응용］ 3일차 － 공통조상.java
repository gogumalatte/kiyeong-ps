import java.util.*;
import java.io.*;

public class Solution {
	static int[] findV;
	static int[] left;
	static int[] right;
	static int parent;
	static int size;
	
	
	public static void main (String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; ++test_case) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			parent = 0;
			size = 0;
			findV = new int[2];
			findV[0] = Integer.parseInt(st.nextToken());
			findV[1] = Integer.parseInt(st.nextToken());
			left = new int[10001];
			right = new int[10001];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < E; ++i) {
				int index = Integer.parseInt(st.nextToken());
				if(left[index] == 0) {
					left[index] = Integer.parseInt(st.nextToken());
				} else {
					right[index] = Integer.parseInt(st.nextToken());
				}
			}
			findCommonParent(findV[0], findV[1]);
			countSize(parent);
			System.out.println("#" + test_case + " " + parent + " " + size);			
		}
	}
	
	// 두 정점의 가장 가까운 공통 조상을 찾는 함수
	public static void findCommonParent(int a, int b) {
		int[] parentsByA = new int[10001];
		int[] parentsByB = new int[10001];
		parentsByA[0] = a;
		int indexA = 1;
		parentsByB[0] = b;
		int indexB = 1;
		/* 모든 조상을 다 담은 다음,
		루트에서부터 내려오며 엇갈리는 즉시 종료하면 가장 가까운 조상을 찾을 수 있다. */
		do {
			parentsByA[indexA] = findParent(parentsByA[indexA - 1]);
			indexA++;
		} while (parentsByA[indexA - 1] != 0);
		do {
			parentsByB[indexB] = findParent(parentsByB[indexB - 1]);
			indexB++;
		} while (parentsByB[indexB - 1] != 0);
		
		while(parentsByA[indexA] == parentsByB[indexB]) {
			parent = parentsByA[indexA];
			indexA--;
			indexB--;
		}
	}
	
	// 해당 정점의 부모를 찾는 함수
	public static int findParent(int n) {
		int res = 0;
		for(int i = 1; i <= 10000; ++i) {
			if(left[i] == n || right[i] == n) {
				res = i;
				break;
			}
		}
		return res;
	}
	
	// 서브 트리의 크기를 계산하는 함수
	public static void countSize(int n) {
		if(n == 0) {
			return;
		}
		
		size++;
		countSize(left[n]);
		countSize(right[n]);
	}
}