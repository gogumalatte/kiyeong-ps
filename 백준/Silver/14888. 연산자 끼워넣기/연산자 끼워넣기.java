import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    // calc(): 피연산자와 연산자 순서를 지정해서 입력값으로 넣어주면 연산 결과를 리턴하는 함수
    public static int calc(int[] operand, int[] operator_list) {
        int answer = operand[0];
        for(int i = 0; i < operator_list.length; ++i) {
            if(operator_list[i] == 0) {
                answer += operand[i+1];
            } else if(operator_list[i] == 1) {
                answer -= operand[i+1];
            } else if(operator_list[i] == 2) {
                answer *= operand[i+1];
            } else if(operator_list[i] == 3) {
                answer /= operand[i+1];
            }
        }
        return answer;
    }
    // permutation(): 연산자 모든 순서 구하기
    public static void permutation(int[] res, int[] operand, int[] operator_list, int depth, int n) {
        if(depth == n) {
            int cur = calc(operand, operator_list);
            if(cur > res[0]) {
                res[0] = cur;
            }
            if(cur < res[1]) {
                res[1] = cur;
            }
            return;
        }
        for(int i = depth; i < n; ++i) {
            swap(operator_list, depth, i);
            permutation(res, operand, operator_list, depth+1, n);
            swap(operator_list, depth, i);
        }
    }
    // swap 함수
    public static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // step1. 입력받기
        int n = sc.nextInt();
        int[] operand = new int[n];
        int[] operator = new int[4]; // 순서대로 덧셈 0, 뺄셈 1, 곱셈 2, 나눗셈 3
        for(int i = 0 ; i < n; ++i) {
            operand[i] = sc.nextInt();
        }
        for(int i = 0; i < 4; ++i) {
            operator[i] = sc.nextInt();
        }

        // step2. 연산자 순열만 지정해서 calc 함수 호출
        int[] operator_list_origin = new int[n-1];
        int index = 0;
        for(int i = 0; i < 4; ++i) {
            while(operator[i] > 0) {
                operator_list_origin[index++] = i;
                operator[i]--;
            }
        }
        int[] res = new int[2];
        res[0] = -100000000;
        res[1] = 1000000000;
        permutation(res, operand, operator_list_origin, 0, index);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}