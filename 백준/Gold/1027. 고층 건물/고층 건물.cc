#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N, seeMax = 0;
    int building[50];
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> building[i];
    }

    for (int i = 0; i < N; i++) // i번째 위치의 빌딩에서
    {
        int curLeft = 0, curRight = 0;
        for (int j = i - 1; j >= 0; j--) // i의 왼쪽에 있는 j번째 위치의 빌딩을 봄.
        {
            bool check = true;
            for (int k = j + 1; k < i; k++) // 빌딩이 가리지 않고 보이는지 체크
            {
                double d = 1.0 * (building[k] - building[i]) / (k - i); // 기울기
                double c = building[k] - d * k;                         // 상수
                if (d * j + c >= building[j])
                {
                    check = false;
                    break;
                }
            }
            if (check)
            {
                curLeft += 1;
            }
        }

        for (int j = i + 1; j < N; j++) // i의 오른쪽에 있는 j번째 위치의 빌딩을 봄.
        {
            bool check = true;
            for (int k = i + 1; k < j; k++) // 빌딩이 가리지 않고 보이는지 체크
            {
                double d = 1.0 * (building[i] - building[k]) / (i - k); // 기울기
                double c = building[k] - d * k;                         // 상수
                if (d * j + c >= building[j])
                {
                    check = false;
                    break;
                }
            }
            if (check)
            {
                curRight += 1;
            }
        }

        seeMax = max(seeMax, (curLeft + curRight));
    }

    cout << seeMax << "\n";

    return 0;
}