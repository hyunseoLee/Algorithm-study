#include<iostream>
#include<cstring>
#include<vector>
using namespace std;
int map[52][52];
bool check[52][52];
int dx[4]= {0,0,1,-1};
int dy[4]= {1,-1,0,0};
int T,N,M,K;
void dfs(int x, int y){
    check[x][y]=true;
    for(int k=0;k<4;k++){
        int nx = x+dx[k];
        int ny = y+dy[k];
        if(nx>=0 && nx<M && ny>=0 && ny<N && map[nx][ny]==1 && check[nx][ny]==false){
            dfs(nx,ny);
        }
    }
}
int main(){
    cin>>T;
    vector<int> v;
    while(T--){

        cin>>N>>M>>K;
        memset(check,false,sizeof(check));
        memset(map,0,sizeof(map));
        for(int i=0;i<K;i++){
            int y,x;
            cin>>y>>x;
            map[x][y]=1;

        }
        int ans=0;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1 && check[i][j]==false){
                    dfs(i,j);
                    ans++;
                }
            }
        }
        v.push_back(ans);
    }

    for(int i=0;i<v.size();i++){
        cout<<v[i] <<'\n';
    }
}