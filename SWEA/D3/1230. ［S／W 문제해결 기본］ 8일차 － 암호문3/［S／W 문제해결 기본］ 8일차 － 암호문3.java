import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int N;
    static int M;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for(int test_case = 1; test_case <= T; ++test_case) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; ++i) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; ++i) {
                char command = st.nextToken().charAt(0);
                if(command == 'I') {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for(int j = 0; j < y; ++j) {
                        int addedNum = Integer.parseInt(st.nextToken());
                        arr.add(x++, addedNum);
                    }
                } else if(command == 'D') {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for(int j = 0; j < y; ++j) {
                        arr.remove(x);
                    }
                } else if(command == 'A') {
                    int y = Integer.parseInt(st.nextToken());
                    for(int j = 0; j < y; ++j) {
                        int addedNum = Integer.parseInt(st.nextToken());
                        arr.add(addedNum);
                    }
                }
            }

            System.out.print("#" + test_case);
            for(int i = 0; i < 10; ++i) {
                   System.out.print(" " + arr.get(i));
            }
            System.out.println();
        }
    }
}