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
            // 이동 가능한 경로를 2차원 배열에 세팅
			int[][] path = new int[100][2];
            for(int i = 0; i < path.length; ++i) {
                for(int j = 0; j < path[0].length; ++j) {
                    path[i][j] = -1;
                }
            }
            int t = sc.nextInt();
            int n = sc.nextInt();
            for(int i = 0; i < n; ++i) {
                int index = sc.nextInt();
                if(path[index][0] == -1) {
                    path[index][0] = sc.nextInt();
                } else {
                 	path[index][1] = sc.nextInt();   
                }
            }
            
            // 방문한 경로를 스택에 저장
            int res = 0;
            Stack<Integer> visited = new Stack<>();
            visited.push(0);
            
            // 비선형 구조의 모든 길을 탐색
            while(!visited.isEmpty()) {
                int curV = visited.peek();
                // 도착지라면 탈출
                if(curV == 99) {
                 	res = 1;
                    break;
                }
                
                // 첫 번째 길로 갈 수 있는지?, 아니라면 두 번째 길로 갈 수 있는지?, 아니라면 이전 길로 돌아가기.
                if(path[curV][0] != -1) {
                 	visited.push(path[curV][0]);
                    path[curV][0] = -1;
                } else if(path[curV][1] != -1) {
                    visited.push(path[curV][1]);
                    path[curV][1] = -1;
                } else {
                 	visited.pop();   
                }
            }
            
            System.out.println("#" + t + " " + res);
		}
	}
}