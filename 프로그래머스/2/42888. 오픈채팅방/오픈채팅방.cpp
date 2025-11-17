#include <string>
#include <vector>
#include <sstream>
#include <map>
#include <iostream>

using namespace std;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    map<string, string> idAndName;
    
    // record 읽으며 띄어쓰기 단위로 단어 분리
    for(string row : record)
    {
        stringstream ss(row);
        string word;
        vector<string> words;
        
        while(getline(ss, word, ' '))
        {
            words.push_back(word);
        }
        
        if(words[0] == "Enter")
        {
            idAndName[words[1]] = words[2];
        }
        
        if(words[0] == "Change")
        {
            idAndName[words[1]] = words[2];
        }
    }
    
    
    // record를 다시 읽으며 유저 아이디(닉네임) 들어온지, 나간지를 answer에 저장
    for(string row : record)
    {
        stringstream ss(row);
        string word;
        vector<string> words;
        string s;
        
        while(getline(ss, word, ' '))
        {
            words.push_back(word);
        }
        
        if(words[0] == "Enter")
        {
            s = idAndName[words[1]] + "님이 들어왔습니다.";
            answer.push_back(s);
        }
        if(words[0] == "Leave")
        {
            s = idAndName[words[1]] + "님이 나갔습니다.";
            answer.push_back(s);
        }
    }
    
    
    
    return answer;
}