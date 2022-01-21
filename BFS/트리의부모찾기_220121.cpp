#include<vector>
#include<queue>
#include<algorithm>
#include<cstring>
#include<iostream>

using namespace std;
vector<int> a[100002];
//int a[100002][100002];
int ans[100002];
bool visit[100002];
int N;

void bfs(int n){

    queue<int> q;
    q.push(n);
    ans[n]=1; 
    visit[n]=true;

    while(!q.empty()){
        int now= q.front(); q.pop();
        for(int i=0;i<a[now].size();i++){
            if(visit[a[now][i]]==false){

                ans[a[now][i]]= now;
                visit[a[now][i]]=true;
                q.push(a[now][i]);
            }
        }
    }

}
int main(){ 
    cin>>N;
    //memset(a,0,sizeof(a));
    memset(visit,false,sizeof(visit));
    visit[1]=true;

    for(int i=0;i<N-1;i++){
        int x,y;
        cin>>x>>y;
        a[x].push_back(y);
        a[y].push_back(x);
       // a[x][y]=a[y][x]=1;
    }

    bfs(1);

    for(int i=2;i<=N;i++){
        cout<< ans[i]<<'\n';
    }
    return 0;
}