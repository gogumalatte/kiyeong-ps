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
            int maxSum = 0;
            // step1. 2차원 배열 채우기
			int inputTestCase = sc.nextInt();
            int[][] arr = new int[100][100];
            for(int i = 0; i < 100; ++i) {
                for(int j = 0; j < 100; ++j) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            // step2. 각 행의 합 중 최댓값 구하기
            for(int i = 0; i < 100; ++i) {
                int rowSum = 0;
                for(int j = 0; j < 100; ++j) {
                    rowSum += arr[i][j];
                }
                maxSum = maxSum > rowSum ? maxSum : rowSum;
            }
            
            // step3. step2의 결과 + 각 열의 합 중 최댓값 구하기
            for(int i = 0; i < 100;  ++i) {
                int colSum = 0;
                for(int j = 0; j < 100; ++j) {
                    colSum += arr[j][i];
                }
                maxSum = maxSum > colSum ? maxSum : colSum;
            }
            
            // step4. step3의 결과 + 각 대각선의 합 중 최댓값 구하기
            int diagonalSum = 0;
            for(int i = 0; i < 100; ++i) {
             	   diagonalSum += arr[i][i];
            }
            maxSum = maxSum > diagonalSum ? maxSum : diagonalSum;
            
            diagonalSum = 0;
            for(int i = 0; i < 100; ++i) {
             	diagonalSum += arr[100-1-i][i];   
            }
            maxSum = maxSum > diagonalSum ? maxSum : diagonalSum;
            
            // step5. 최댓값 출력
            System.out.println("#" + inputTestCase + " " + maxSum);
		}
	}
}