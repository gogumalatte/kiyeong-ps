#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    bool answer = true;
    int sum = 0;
    int original = x;
    while(x)
    {
        sum += x % 10;
        x /= 10;
    }
    if(original % sum != 0)
    {
        answer = false;
    }
    return answer;
}