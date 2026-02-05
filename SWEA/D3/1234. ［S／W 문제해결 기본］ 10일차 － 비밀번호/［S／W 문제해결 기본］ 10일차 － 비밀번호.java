import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            String password = sc.next();
            char[] passwordArr = password.toCharArray();
            Deque<Character> stack = new ArrayDeque<>();

            for(int i = 0; i < n; ++i) {
                if(!stack.isEmpty() && passwordArr[i] == stack.peek()) {
                    stack.pop();   
                } else {
                    stack.push(passwordArr[i]);   
                }
            }

            int[] res = new int[n];
            int i = 0;
            while(!stack.isEmpty()) {
                res[i++] = stack.pop() - '0';
            }

            System.out.print("#" + test_case + " ");
            i--;
            for(; i >= 0; --i) {
                System.out.print(res[i]);
            }
            System.out.println();
		}
	}
}