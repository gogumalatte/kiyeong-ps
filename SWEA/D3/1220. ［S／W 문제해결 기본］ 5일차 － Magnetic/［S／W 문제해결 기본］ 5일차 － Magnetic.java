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
            // step1. 테이블에 자성체 데이터 채우기: 1은 아래로, 2는 위로 이끌림.
			int n = sc.nextInt();
            int[][] table = new int[n][n];
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
             		table[i][j] = sc.nextInt();
                }
            }
            
            // step2. 1 -> 2 순서대로 있는 쌍 찾기
            int res = 0;
            for(int i = 0; i < n; ++i) {
                boolean check_n = false;
                for(int j = 0; j < n; ++j) {
                    if(table[j][i] == 1) {
                        check_n = true;
                    }
                    if(check_n == true && table[j][i] == 2) {
                        res++;
                        check_n = false;
                    }
                }
            }
            
            // step3. 교착 상태의 개수 출력
            System.out.println("#" + test_case + " " + res);
		}
	}
}