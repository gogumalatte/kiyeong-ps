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
			int buildings = sc.nextInt();
            int[] arr = new int[buildings];
            int res = 0;
            for(int i = 0; i < buildings; i++)
            {
             	arr[i] = sc.nextInt();   
            }
            
            for(int i = 2; i < buildings - 2; i++)
            {
                int maxH = 0;
                for(int j = i-2; j < i; j++)
                {
                 	if(arr[j] > maxH) maxH = arr[j];   
                }
                for(int j = i+1; j <= i+2; j++)
                {
                 	if(arr[j] > maxH) maxH = arr[j];   
                }
                
                res = arr[i] - maxH > 0 ? res + (arr[i] - maxH) : res;
            }
			System.out.println("#" + test_case + " " + res);
		}
	}
}