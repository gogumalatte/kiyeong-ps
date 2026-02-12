import java.util.*;
import java.io.*;

public class Solution {
	static int[] costs = new int[4];
	static int[] plans = new int[12];
	static int res;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.clear();
			for (int i = 0; i < 4; ++i) {
				costs[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; ++i) {
				plans[i] = Integer.parseInt(st.nextToken());
			}
			res = costs[3];

			solve(0);
			System.out.println("#" + test_case + " " + res);
		}
	}

	private static void solve(int depth) {
		if (depth == 12) {
			calc();
			return;
		}

		for (int i = 0; i < 3; ++i) {
			list.add(i);
			solve(depth + 1);
			list.remove(list.size() - 1);
		}
	}

	private static void calc() {
		int cur = 0;
		for (int i = 0; i < 12; ++i) {
			if (plans[i] == 0) {
				continue;
			}

			int listValue = list.get(i);
			if (listValue == 0) {
				cur += plans[i] * costs[listValue];
			} else if (listValue == 1) {
				cur += costs[listValue];
			} else if (listValue == 2) {
				cur += costs[listValue];
				i += 2;
			}
		}
		res = Math.min(res, cur);
	}
}
