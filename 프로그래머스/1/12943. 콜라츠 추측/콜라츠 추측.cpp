#include <string>
#include <vector>

using namespace std;

int solution(int num) {
    int answer = 0;
    long long n = num;
    while(true)
    {
        // 종료조건
        if(n == 1)
        {
            break;
        }
        else if(answer >= 500)
        {
            answer = -1;
            break;
        }
        
        if(n % 2 == 0)
        {
            n /= 2;
            ++answer;
        }
        else
        {
            n *= 3;
            n += 1;
            ++answer;
        }
        
    }
    return answer;
}