#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int width_max = 0;
    int height_max = 0;
    
    for(int i = 0; i < sizes.size(); ++i)
    {
        if(sizes[i][0] > sizes[i][1])
        {
            width_max = sizes[i][0] > width_max ? sizes[i][0] : width_max;
            height_max = sizes[i][1] > height_max ? sizes[i][1] : height_max;
        }
        else
        {
            width_max = sizes[i][1] > width_max ? sizes[i][1] : width_max;
            height_max = sizes[i][0] > height_max ? sizes[i][0] : height_max;
        }
    }
    
    
    return width_max * height_max;
}