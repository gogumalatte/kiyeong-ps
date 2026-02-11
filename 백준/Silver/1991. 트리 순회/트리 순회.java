import java.util.*;
import java.io.*;

class Node {
	char value, left, right;
}

public class Main {
	static Node[] tree;
	static int n;
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		tree = new Node[n+1];
		
		for(int i = 1; i <= n; ++i) {
			tree[i] = new Node();
		}
		
		for(int i = 1; i <= n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char value = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			tree[(int)(value - 'A') + 1].value = value;
			if(left != '.') {
				tree[(int)(value - 'A') + 1].left = left;
			}
			if(right != '.') {
				tree[(int)(value - 'A') + 1].right = right;
			}
		}
		
		solve();
	}
	
	private static void solve() {
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
		System.out.println();
	}
	
	private static void preorder(int v) {
		if(v <= 0 || v > n || tree[v] == null) {
			return;
		}
		System.out.print(tree[v].value);
		preorder((int)(tree[v].left - 'A') + 1);
		preorder((int)(tree[v].right - 'A') + 1);
	}
	
	private static void inorder(int v) {
		if(v <= 0 || v > n || tree[v] == null) {
			return;
		}
		inorder((int)(tree[v].left - 'A') + 1);
		System.out.print(tree[v].value);
		inorder((int)(tree[v].right - 'A') + 1);
	}
	
	private static void postorder(int v) {
		if(v <= 0 || v > n || tree[v] == null) {
			return;
		}
		postorder((int)(tree[v].left - 'A') + 1);
		postorder((int)(tree[v].right - 'A') + 1);
		System.out.print(tree[v].value);
	}
	
	
}
