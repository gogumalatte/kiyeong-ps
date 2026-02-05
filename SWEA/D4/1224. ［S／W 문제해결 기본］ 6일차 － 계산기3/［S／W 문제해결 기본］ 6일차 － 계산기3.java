import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            String s = sc.next();
            char[] originArr = s.toCharArray();
            char[] changedArr = new char[originArr.length];
            
            Deque<Character> stack = new ArrayDeque<>();
            
            // step1. 후위연산식으로 변환
            int top = 0;
            for(int i = 0; i < n; ++i) {
             	// 피연산자(숫자)면?
                if(originArr[i] >= '0' && originArr[i] <= '9') {
                    changedArr[top++] = originArr[i];
                }
                // 더하기이면?
                if(originArr[i] == '+') {
                    while(stack.peek() == '+' || stack.peek() == '*') {
                     	changedArr[top++] = stack.pop();   
                    }
                    stack.push('+');
                }
                // 곱하기이면? 스택에서 top에 '*'이 있다면 모두 뽑고, push
                if(originArr[i] == '*') {
                    while(stack.peek() == '*') {
                     	changedArr[top++] = stack.pop();   
                    }
                    stack.push('*');
                }
                // 여는 괄호이면? 스택에 그냥 넣는다.
                if(originArr[i] == '(') {
                    stack.push('(');
                }
                // 닫는 괄호이면? 스택에서 여는 괄호를 뽑을 때까지 모두 뺀다.
                if(originArr[i] == ')') {
                    while(stack.peek() != '(') {
                     	changedArr[top++] = stack.pop();   
                    }
                    stack.pop();
                }
            }
            while(!stack.isEmpty()) {
             	changedArr[top++] = stack.pop();   
            }
            
            // step2. 후위연산식을 계산
            Deque <Long> calc = new ArrayDeque<>();
            for(int i = 0; i < top; ++i) {
                if(changedArr[i] >= '0' && changedArr[i] <= '9') {
                    calc.push((long) changedArr[i] - '0');
                } else if(changedArr[i] == '+') {
                 	long b = calc.pop();
                    long a = calc.pop();
                    calc.push(a+b);
                } else {
                    long b = calc.pop();
                    long a = calc.pop();
                    calc.push(a*b);
                }
            }
            
            long res = calc.pop();
            System.out.println("#" + test_case + " " + res);
		}
	}
}