#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(int n) {
    int answer = 0;
    vector<int> box;
    while(n)
    {
        box.push_back(n % 3);
        n /= 3;
    }
    
    for(int i = 0; i < box.size(); i++)
    {
        answer += box[i] * pow(3, box.size()-1-i);
    }
    return answer;
}