#include <vector>
#include <cmath>
#include <iostream>

using namespace std;

vector<int> solution(int n, int m) {
    vector<int> answer;
    // step1. 최대공약수 구하기
    int a = n > m ? m : n;
    for(int i = a; i >= 1; --i)
    {
        if(n % i == 0 && m % i == 0)
        {
            answer.push_back(i);
            break;
        }
    }
    
    // step2. 최소공배수 구하기
    int b = n > m ? n : m;
    for(int i = b; i <= n * m; ++i)
    {
        if(i % n == 0 && i % m == 0)
        {
            answer.push_back(i);
            break;
        }
    }
    return answer;
}