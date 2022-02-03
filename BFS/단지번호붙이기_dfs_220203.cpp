#include<iostream>
#include<vector>
#include<cstring>
using namespace std;
#define MAX 26
char map[MAX][MAX];
bool check[MAX][MAX];
int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};
int N;
int cnt;
void dfs(int x, int y){
    check[x][y]=true;
    cnt++;

    for(int k=0;k<4;k++){
        int nx= x+dx[k];
        int ny= y+dy[k];
        if(nx>=0 && nx<N && ny>=0 && ny<N && check[nx][ny]==false && map[nx][ny]=='1'){
            dfs(nx,ny);
        }
    }
}
int main(){
    cin>>N;
    memset(check,false,sizeof(check));
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            cin>>map[i][j];
        }
    }
    vector<int> v;
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            if(map[i][j]=='1' && check[i][j]==false){
                cnt=0;
                dfs(i,j);
                v.push_back(cnt);
            }
        }
    } 
    cout<< v.size() <<'\n';
    sort(v.begin(),v.end());
    for(int i=0;i<v.size();i++){
        cout<<v[i] <<'\n';
    }
    return 0;
}