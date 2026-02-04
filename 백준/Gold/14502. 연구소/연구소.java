import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int solve(int[][] origin, int first, int second, int third) {
        Queue<int[]> queue = new ArrayDeque<>();
        int safe = 0;

        // origin 배열이 오염되지 않게 새로운 배열에 값 복사
        int[][] curMap = new int[origin.length][origin[0].length];
        for(int i = 0; i < origin.length; ++i) {
            for(int j = 0; j < origin[0].length; ++j) {
                curMap[i][j] = origin[i][j];
                if(curMap[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        curMap[first/origin[0].length][first%origin[0].length] = 1;
        curMap[second/origin[0].length][second%origin[0].length] = 1;
        curMap[third/origin[0].length][third%origin[0].length] = 1;

        // bfs() : 바이러스 퍼뜨리기
        int[] dx = {1, 0, -1, 0}; // 오른쪽, 아래, 왼쪽, 위
        int[] dy = {0, -1, 0, 1};
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i = 0; i < dx.length; ++i) {
                int nx = cur[1] + dx[i];
                int ny = cur[0] + dy[i];
                if(nx >= 0 && nx < curMap[0].length && ny >= 0 && ny < curMap.length) {
                    if(curMap[ny][nx] == 0) {
                        queue.offer(new int[] {ny, nx});
                        curMap[ny][nx] = 2;
                    }
                }
            }
        }

        // 안전 구역 구하기
        for(int i = 0; i < curMap.length; ++i) {
            for(int j = 0; j < curMap[0].length; ++j) {
                if(curMap[i][j] == 0) {
                    safe++;
                }
            }
        }
        
        return safe;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 세로 크기
        int m = sc.nextInt(); // 가로 크기
        int[][] map = new int[n][m];

        // step1. 지도 초기화, 바이러스 초기 위치 큐에 저장
        for(int i = 0; i < n; ++i) {
            for(int j = 0 ; j < m; ++j) {
                map[i][j] = sc.nextInt();
            }
        }

        // step2. 지도에서 벽 세울 곳 3개 고르기 - 완전탐색
        int res = 0;
        int x = 0;
        for(int i = 0; i < n * m - 2; ++i) {
            for(int j = i + 1; j < n * m - 1; ++j) {
                for(int k = j + 1; k < n * m; ++k) {
                    // 빈 칸인지 확인
                    if(map[i/m][i%m] == 0 && map[j/m][j%m] == 0 && map[k/m][k%m] == 0) {
                        // step3. 바이러스 퍼뜨리기 BFS + step4. 안전 구역 구하기
                        int cur = solve(map, i, j, k);
                        res = Math.max(res, cur);
                    }
                }
            }
        }
        System.out.println(res);
    }
}