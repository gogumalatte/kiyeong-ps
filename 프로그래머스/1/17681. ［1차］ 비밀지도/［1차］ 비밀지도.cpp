#include <string>
#include <vector>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    for(int i = 0; i < n; i++)
    {
        string line = "";
        vector<int> line1(n);
        vector<int> line2(n);
        
        for(int j = n - 1; j >= 0; --j)
        {
            line1[j] = arr1[i] % 2;
            arr1[i] /= 2;
        }
        
        for(int j = n - 1; j >= 0; --j)
        {
            line2[j] = arr2[i] % 2;
            arr2[i] /= 2;
        }
        
        for(int j = 0; j < n; ++j)
        {
            if(line1[j] == 1 || line2[j] == 1)
            {
                line += "#";
            }
            else
            {
                line += " ";
            }
        }
        answer.push_back(line);
    }
    return answer;
}