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
			int inputTestCase = sc.nextInt();
            int[][] ladder = new int[100][100];
            // step1. 사다리 데이터 입력받기
            for(int i = 0; i < 100; ++i) {
                for(int j = 0 ; j < 100; ++j) {
					ladder[i][j] = sc.nextInt();
                }
            }
			
            // step2. 도착지점의 x 좌표 구하기
            int destinationX = 0;
            for(int i = 0; i < 100; ++i) {
             	if(ladder[99][i] == 2) {
                    destinationX = i;
                    break;
                }
            }
            // System.out.println("#" + inputTestCase + " " + destinationX);
            
            // step3. y좌표가 0이 될 때까지 올라가면서, 왼쪽 or 오른쪽에 길이 있으면 이동하기.
            int curX = destinationX;
            int curY = 99;
           	do {
                // 현재 지나온 길은 체크
                ladder[curY][curX] = -1;
                // 왼쪽 길이 있는지 확인 -> 있다면 이동
                if(curX - 1 >= 0 && ladder[curY][curX-1] == 1) {
                    curX--;
                    continue;
                }
                // 오른쪽 길이 있는지 확인 -> 있다면 이동
                if(curX + 1 < 100 && ladder[curY][curX+1] == 1) {
                 	curX++;
                    continue;
                }
                curY--;
            } while(curY > 0);
			
            // step4. 출발지점에서의 x위치를 출력
            System.out.println("#" + inputTestCase + " " + curX);
		}
	}
}