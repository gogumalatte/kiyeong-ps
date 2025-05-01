#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N, M, count = 0;
    cin >> N >> M;
    vector<vector<int>> graphs(N + 1);
    vector<bool> vertexs(N + 1, false);

    for (int i = 0; i < M; i++)
    {
        int temp1, temp2;
        cin >> temp1 >> temp2;
        graphs[temp1].push_back(temp2);
        graphs[temp2].push_back(temp1);
    }

    stack<int> s;
    for (int i = 1; i <= N; i++)
    {
        if (vertexs[i] == false)
        {
            count += 1;
            vertexs[i] = true;
            s.push(i);
            while (!s.empty())
            {
                int temp = s.top();
                s.pop();
                for (int j : graphs[temp])
                {
                    if (!vertexs[j])
                    {
                        s.push(j);
                        vertexs[j] = true;
                    }
                }
            }
        }
    }

    cout << count << "\n";
    return 0;
}