#include <algorithm>
#include <vector>

using namespace std;

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    vector<int> box(10000001);
    for(int i : tangerine)
    {
        box[i]++;
    }
    
    sort(box.rbegin(), box.rend());
    while(k > 0)
    {
        k -= box[answer++];
    }
    return answer;
}