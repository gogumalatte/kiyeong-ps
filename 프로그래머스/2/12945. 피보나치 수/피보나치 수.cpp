#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    vector<long long> fibo(100000);
    fibo[0] = 0;
    fibo[1] = 1;
    for(int i = 2; i <= n; ++i)
    {
        fibo[i] = ((fibo[i-2] % 1234567) + (fibo[i-1] % 1234567)) % 1234567;
    }
    return fibo[n];
}