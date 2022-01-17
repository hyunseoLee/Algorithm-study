#include <vector>
#include <iostream>
#include <algorithm>
#include <cstring>
#include <queue>

using namespace std;

char a[26][26];
bool check[26][26];
int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};
int n;

int bfs(int x, int y){ // 단지의 총갯수를 return한다. 
    int ans_num = 0;
    queue<pair<int,int>> q;
    q.push(make_pair(x,y));
    check[x][y]=true;

    while(!q.empty()){
        int x= q.front().first;
        int y= q.front().second;
        q.pop();
        ans_num++;

        for(int k=0;k<4;k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx>=0 && nx<n && ny>=0 && ny<n && a[nx][ny]=='1' && check[nx][ny]==false){
                q.push(make_pair(nx,ny));
                check[nx][ny]=true;
            }
        }


    }
    
    return ans_num;


}
int main()
{
    cin>>n;
    vector<int> v;
    int ans=0;
    memset(check,false,sizeof(check));

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin>>a[i][j];
        }
    }
    
    for(int i=0;i<n;i++){
        for( int j=0;j<n;j++){
            if(a[i][j]=='1' && check[i][j]==false){
                v.push_back(bfs(i,j));
                ans++;    
            }
        }
    }
    cout<<ans<<'\n';
    sort(v.begin(),v.end());
    for(int i=0;i<v.size();i++){
        cout<<v[i]<< '\n';
    }
    return 0;
}
