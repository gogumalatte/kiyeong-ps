#include <string>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    vector<int> box;
    while(n)
    {
        box.push_back(n%10);
        n /= 10;
    }
    sort(box.begin(), box.end());
    for(int i = 0; i < box.size(); i++)
    {
        answer += box[i] * (pow(10, i));
    }
    return answer;
}