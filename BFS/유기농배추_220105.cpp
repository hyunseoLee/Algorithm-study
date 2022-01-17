#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int a[51][51];
bool check[51][51];

int n,m,k;
int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};

void bfs(int x,int y){
    queue<pair<int,int>> q;
    q.push(make_pair(x,y));
    check[x][y]=true;

    while(!q.empty()){
        int x= q.front().first;
        int y= q.front().second;
        q.pop();

        for(int k=0;k<4;k++){
            int nx = x+dx[k];
            int ny = y+dy[k];
            if(nx>=0 && nx<m && ny>=0 && ny<n && a[nx][ny]==1 && check[nx][ny]==false){
                q.push(make_pair(nx,ny));
                check[nx][ny]=true;
            }
        }

    }
}

int main(){
    int T;
    cin>>T;
    for(int t=0;t<T;t++){
        cin>>m>>n>>k;
        //1. m*n 배열 초기화 
        memset(check,false,sizeof(check));
        memset(a,0,sizeof(a));

        //2. 배추 있는 배열 1로 세팅
        for(int j=0;j<k;j++){
            int x,y;
            cin>>x>>y;
            a[x][y]=1;
        }

        //3. 배추가 있는 행열만 bfs 넣고..
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]==1 && check[i][j]==false){
                    bfs(i,j);
                    ans++;
                }
            }
        }

        cout << ans <<'\n';

    }
    return 0;
}