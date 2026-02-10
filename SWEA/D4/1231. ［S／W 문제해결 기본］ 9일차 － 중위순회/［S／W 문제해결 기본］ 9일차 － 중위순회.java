import java.util.*;
import java.io.*;

class Node {
	int left;
	int right;
	char value;
}

public class Solution {
	static Node[] tree;
	
	public static void main (String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T= 10;
		for(int test_case = 1; test_case <= T; ++test_case) {
			int n = Integer.parseInt(br.readLine());
			tree = new Node[n+1];
			for (int i = 1; i <= n; i++) {
				tree[i] = new Node();
			}
			
			for(int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());
				tree[index].value = st.nextToken().charAt(0);
				if(st.hasMoreTokens()) {	
					tree[index].left = Integer.parseInt(st.nextToken());
				} 
				if(st.hasMoreTokens()) {
					tree[index].right = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.print("#" + test_case + " ");
			inorder(1);
			System.out.println();
		}
	}
	private static void inorder(int v) {
		if(v == 0 || tree[v] == null) {
			return;
		}
		
		inorder(tree[v].left);
		System.out.print(tree[v].value);
		inorder(tree[v].right);
	}
}