#include <string>
#include <vector>

using namespace std;

double solution(vector<int> arr) {
    double answer = 0;
    for(int value : arr)
    {
        answer += value;
    }
    return answer / arr.size();
}