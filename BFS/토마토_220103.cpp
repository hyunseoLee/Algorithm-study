#include<iostream>
#include<queue>
#include <algorithm>
using namespace std;
int n,m;
bool check[1002][1002];
int a[1002][1002];
int result[1002][1002];
int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};
int main(){
    cin>>n>>m;
    queue<pair<int,int>> q;
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            cin>>a[i][j];
            if(a[i][j]==1){
                q.push(make_pair(i,j));
                check[i][j]=true;
                result[i][j]= 0;
            }
        }
    }
    //int cnt=1;
    while(!q.empty()){
        int x= q.front().first;
        int y= q.front().second;
        q.pop();

        for(int k=0;k<4;k++){
            int nx = x+ dx[k];
            int ny = y+ dy[k];
            if(check[nx][ny]==false && nx>=0 && ny>=0 && nx<m && ny<n && a[nx][ny]==0){
                q.push(make_pair(nx,ny));
                check[nx][ny]= true;
                result[nx][ny]= result[x][y]+1;
            } 
        }

    }

    // 결과값 추출
    int ans = 0;
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            ans = max(ans,result[i][j]);
        }
    }
    // 1-2. 다 익지 못하는 경우
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(result[i][j] == 0 && a[i][j]==0){
                ans = -1; break;
            }
        }
    }

    cout << ans <<'\n';
    return 0;
}