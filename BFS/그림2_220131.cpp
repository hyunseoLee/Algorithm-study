#include <iostream> 
#include <vector>
#include <algorithm>
using namespace std;
 
int n, m;
const int MAX = 501;
int map[MAX][MAX] = { 0, };
bool visited[MAX][MAX] = { 0, };
int dy[] = { 0,0,-1,1 };
int dx[] = { 1,-1,0,0 };

int cnt = 0;
void DFS(int x, int y) {

    visited[x][y] = true;
    cnt++;
 
    for (int i = 0; i < 4; i++) {
       
        int nx = x + dx[i];
        int ny = y + dy[i];
 
        if (ny >= 0 && nx >= 0 && ny<m && nx<n && map[nx][ny]== 1 && visited[nx][ny]== 0) {
            visited[nx][ny] = true;           
            DFS(nx, ny);
        }
    }
}
int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> map[i][j];
        }
    }
    int num = 0;   //영역 개수
    int ans = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (map[i][j] == 1&&visited[i][j]==0) {
                cnt=0;
                DFS(i,j);
                ans= max(ans,cnt);
                num++; 
            }
        }
    }
    cout<< num<<'\n' << ans<<'\n';
}
