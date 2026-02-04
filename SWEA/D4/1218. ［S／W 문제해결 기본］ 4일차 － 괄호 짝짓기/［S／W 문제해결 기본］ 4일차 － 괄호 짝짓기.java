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
			int arrSize = sc.nextInt();
            String s = sc.next();
            char[] charArr = s.toCharArray();
            Stack<Character> check = new Stack<>();
            int res = 1;
            
			for(int i = 0; i < arrSize; ++i) {
                // 여는 괄호일 때는 stack에 추가만 해준다.
                if(charArr[i] == '(' || charArr[i] == '[' || charArr[i] == '{' || charArr[i] == '<') {
                    check.push(charArr[i]);
                }
                // 닫는 괄호일 때는 여는 괄호가 스택의 가장 위에 있는지 확인한다.
                if(charArr[i] == ')') {
                 	if(check.isEmpty()) {
                     	res = 0;
                        break;
                    }
                    if(check.pop() != '(') {
                     	res = 0;
                        break;
                    }
                }
                
                if(charArr[i] == ']') {
                 	if(check.isEmpty()) {
                     	res = 0;
                        break;
                    }
                    if(check.pop() != '[') {
                     	res = 0;
                        break;
                    }
                }
                
                if(charArr[i] == '}') {
                 	if(check.isEmpty()) {
                     	res = 0;
                        break;
                    }
                    if(check.pop() != '{') {
                     	res = 0;
                        break;
                    }
                }
                
                if(charArr[i] == '>') {
                 	if(check.isEmpty()) {
                     	res = 0;
                        break;
                    }
                    if(check.pop() != '<') {
                     	res = 0;
                        break;
                    }
                }
            }
            
            // 마지막에 남아 있는 괄호가 있다면 유효하지 않다.
            if(!check.isEmpty()) {
                res = 0; 
            }
            
            System.out.println("#" + test_case + " " + res);
		}
	}
}