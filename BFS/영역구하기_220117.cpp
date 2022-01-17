#include<iostream>
#include<cstring>
#include<vector>
#include<queue>
using namespace std;
int M,N,K;
int a[101][101];
bool check[101][101];
int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};
int bfs(int x, int y){
    queue<pair<int,int>> q;
    q.push(make_pair(x,y));
    check[x][y]= true;
    int ans = 1;

    while(!q.empty()){
        int x= q.front().first;
        int y= q.front().second;
        q.pop();

        for(int k=0;k<4;k++){
            int nx = x+dx[k];
            int ny = y+dy[k];
            if(nx>=0 && nx<M && ny>=0 && ny<N && a[nx][ny]==0 && check[nx][ny]==false){
                q.push(make_pair(nx,ny));
                check[nx][ny]=true;
                ans++;

            }
        }
    }
    return ans;
}
int main(){
    cin>>M>>N>>K;
    memset(a,0,sizeof(a));
    memset(check,false,sizeof(check));
    for(int i=0;i<K;i++){
        int x1,y1,x2,y2;
        cin>>x1>>y1>>x2>>y2;
        int nx1= M-y1; int ny1= x1;
        int nx2= M-y2; int ny2= x2;

        for(int x=nx2;x<nx1;x++){
            for(int y=ny1;y<ny2;y++){
                a[x][y]=1;
            }
        }

    }
    vector<int> v;
    for(int i=0;i<M;i++){
        for(int j=0;j<N;j++){
            if(a[i][j]==0 && check[i][j]==false){
                v.push_back(bfs(i,j));
 
            }
        }
    }


    sort(v.begin(), v.end());
    cout<<v.size() <<'\n';
    for(int i=0;i<v.size();i++){
        cout<< v[i] <<' ';
    }
    return 0;
}