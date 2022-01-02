#include <iostream>
#include <vector>
using namespace std;
char num[51][51];

int Chess_Count(int x, int y)
{
    // 1. 첫번째 값이 W 인 경우
    char start_color = 'W';
    int x_mod = x % 2;
    int y_mod = y % 2;

    int count_W = 0; int count_B = 0;
    int result = 0;

    for (int i = x; i < x + 8; i++){
        for (int j = y; j < y + 8; j++){
            if (i%2 == x_mod && j%2 == y_mod){ if (num[i][j] != start_color) count_W++;}
            else if (i%2 != x_mod && j%2 != y_mod){ if (num[i][j] != start_color) count_W++;}
            else{ if (num[i][j] == start_color) count_W++; }
        }
    }
    // 2. 첫번째 값이 B 인 경우   
    start_color = 'B';
    for (int i = x; i < x + 8; i++){
        for (int j = y; j < y + 8; j++){
            if (i % 2 == x_mod && j % 2 == y_mod){  if (num[i][j] != start_color) count_B++; }
            else if (i % 2 != x_mod && j % 2 != y_mod) { if (num[i][j] != start_color) count_B++; }
            else {  if (num[i][j] == start_color)   count_B++; }
        }
    }
    // 둘 중 최소값 반환
    result = min(count_W, count_B);

    return result;
}
int main()
{
    int n, m;
    int ans = 51 * 51;
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> num[i][j];
        }
    }
    //1. 8*8 배열을 정하기
    int i = 0;
    int j = 0;
    for (int x = i; x < i + 8; x++){
        if (i + 8 > n)  break; //범위 벗어나면 끝
        j = 0;
        for (int y = j; y < j + 8; y++){
            if (j + 8 > m)  break; //범위 벗어나면 끝
            //x,y좌표로 체스판 갯수확인 함수
            ans = min(ans, Chess_Count(x, y)); //첫번째가 W인 경우 카운트 확인
            j++;
        }
        i++;
    }
    cout << ans << '\n';

    return 0;
}
