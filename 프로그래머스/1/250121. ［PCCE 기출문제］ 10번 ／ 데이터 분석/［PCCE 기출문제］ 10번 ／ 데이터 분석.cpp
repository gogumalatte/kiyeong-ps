#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> data, string ext, int val_ext, string sort_by) {
    vector<vector<int>> answer;
    
    // step1. ext와 sort_by 위치 변수에 담기
    int ext_index = -1;
    int sort_index = -1;
    
    if(ext == "code")
    {
        ext_index = 0;
    }
    else if(ext == "date")
    {
        ext_index = 1;
    }
    else if(ext == "maximum")
    {
        ext_index = 2;
    }
    else if(ext == "remain")
    {
        ext_index = 3;
    }
    
    if(sort_by == "code")
    {
        sort_index = 0;
    }
    else if(sort_by == "date")
    {
        sort_index = 1;
    }
    else if(sort_by == "maximum")
    {
        sort_index = 2;
    }
    else if(sort_by == "remain")
    {
        sort_index = 3;
    }
    
    // step2. ext < val_ext인 값들만 answer에 저장
    for(int i = 0; i < data.size(); ++i)
    {
        if(data[i][ext_index] < val_ext)
        {
            answer.push_back(data[i]);
        }
    }
    
    // step3. answer의 데이터를 sort_by에 따라 오름차순으로 정렬
    for(int i = 0; i < answer.size() - 1; ++i)
    {
        vector<int> temp;
        int min_sort_value = answer[i][sort_index];
        int min_sort_index = -1;
        
        for(int j = i + 1; j < answer.size(); ++j)
        {
            if(min_sort_value > answer[j][sort_index])
            {
                min_sort_value = answer[j][sort_index];
                temp = answer[j];
                min_sort_index = j;
            }
        }
        
        if(min_sort_index != -1)
        {
            answer[min_sort_index] = answer[i];
            answer[i] = temp;
        }
    }
    
    
    return answer;
}