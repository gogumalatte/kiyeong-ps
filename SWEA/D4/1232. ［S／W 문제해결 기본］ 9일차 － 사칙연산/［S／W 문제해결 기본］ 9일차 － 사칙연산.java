import java.util.*;
import java.io.*;

class Node {
	int left;
	int right;
	int num;
	char op;
}

public class Solution {
	static Node[] tree;
	static Deque<Integer> stack = new ArrayDeque<>();
	
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
				String value = st.nextToken();
				char c = value.charAt(0);
				if(c == '+' || c == '-' || c == '*' || c == '/') {
					tree[index].op = c;
					tree[index].left = Integer.parseInt(st.nextToken());
					tree[index].right = Integer.parseInt(st.nextToken());
				} else {
					tree[index].num = Integer.parseInt(value);
				}
			}
			
			postorder(1);
			System.out.println("#" + test_case + " " + stack.pop());
		}
	}
	
	private static void postorder(int v) {
		if(v == 0 || tree[v] == null) {
			return;
		}
		
		postorder(tree[v].left);
		postorder(tree[v].right);
		if(tree[v].num == 0) {
			int b = stack.pop();
			int a = stack.pop();
			if(tree[v].op == '+') {
				stack.push(a + b);
			} else if(tree[v].op == '-') {
				stack.push(a - b);
			} else if(tree[v].op == '*') {
				stack.push(a * b);
			} else if(tree[v].op == '/') {
				stack.push(a / b);
			}
		} else {
			stack.push(tree[v].num);
		}
	}
}