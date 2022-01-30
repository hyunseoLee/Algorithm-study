#include <queue>
#include <iostream>
using namespace std;
#define MAX 501
int a[MAX][MAX];
bool check[MAX][MAX];
int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};
int N,M;
int num=0; 
int bfs(int x, int y){
    queue<pair<int,int>> q;
    q.push(make_pair(x,y));
    check[x][y]= true;
    
    int cnt=0;
    
    while(!q.empty()){
        int x= q.front().first;
        int y =q.front().second;
        q.pop();
        
        cnt++;
        for(int k=0;k<4;k++){
            int nx= x+ dx[k];
            int ny= y+ dy[k];
            if(nx>=0 && nx<N && ny>=0 && ny<M && check[nx][ny]==false && a[nx][ny]==1){
                q.push(make_pair(nx,ny));
                check[nx][ny]=true;
            }
        }

    }

    return cnt;

}
int main(){
    int ans = 0;
    int num = 0;
    cin>>N>>M;
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            cin>>a[i][j];
        }
    }
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            if(a[i][j]==1 && check[i][j]==false) {
                ans= max(ans,bfs(i,j));
                num++;
            };
        }
    }
    cout<< num <<'\n';
    cout<< ans<<'\n';

    return 0;
}
