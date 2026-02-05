import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            
            for(int i = 0; i < n; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; ++j) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int[] res = {987654321, 0}; 
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    int[] cur = bfs(arr, i, j, n);
                    if(cur[1] > res[1] || (cur[1] == res[1] && cur[0] < res[0])) {
                        res = cur;
                    }
                }
            }
			System.out.println("#" + test_case + " " + res[0] + " " + res[1]);
		}
	}
    
    public static int[] bfs(int[][] arr, int i, int j, int n) {
        int[][] visited = new int[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[] {i, j});
        visited[i][j] = -1;
        int[] dx = {1, 0, -1, 0}; // 오른쪽, 아래, 왼쪽, 위
        int[] dy = {0, -1, 0, 1};
        int[] res = {arr[i][j], 1};
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll(); 
            visited[cur[0]][cur[1]] = -1;
            
            for(int k = 0; k < 4; ++k) {
             	int nx = cur[1] + dx[k];
                int ny = cur[0] + dy[k];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if(visited[ny][nx] != -1 && arr[ny][nx] == arr[cur[0]][cur[1]] + 1) {
                     	res[1]++;
                        queue.offer(new int[] {ny, nx});
                    }
                }
            }
        }
        return res;
    }
}