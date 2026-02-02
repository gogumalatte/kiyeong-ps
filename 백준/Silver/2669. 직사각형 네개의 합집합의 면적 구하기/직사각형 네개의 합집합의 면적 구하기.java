import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int[][] board = new int[101][101];
        int[][] inputSquares = new int[4][4];
        int res = 0;

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                inputSquares[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < 4; i++) {
            for(int w = inputSquares[i][0]; w < inputSquares[i][2]; w++) {
                for(int h = inputSquares[i][1]; h < inputSquares[i][3]; h++) {
                    board[h][w] = 1;
                }
            }
        }

        for(int i = 0; i <= 100; i++) {
            for(int j = 0; j <= 100; j++) {
                if(board[i][j] == 1) {
                    res++;
                }
            }
        }

        System.out.println(res);
	}
}