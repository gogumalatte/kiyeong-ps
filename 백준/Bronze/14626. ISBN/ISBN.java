import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int checkIndex = -1;
        int total = 0;
        int res = 0;
        char[] charArr = s.toCharArray();
        for(int i = 0; i < charArr.length; ++i) {
            if(charArr[i] != '*') {
                if(i % 2 == 0) {
                    total += (charArr[i] - '0') % 10;
                } else {
                    total += ((charArr[i] - '0') * 3) % 10;
                }
            } else {
                checkIndex = i;
            }
        }
        
        if(checkIndex % 2 == 0) {
            total = total % 10;
            res = (10 - total) % 10;
        } else {
            for(int i = 0; i <= 9; ++i) {
                if((3 * i + total) % 10 == 0) {
                    res = i;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}