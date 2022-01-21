#include<vector>
#include<queue>
#include<algorithm>
#include<cstring>
#include<iostream>
using namespace std;
int N,M;
int a[101][101];
bool visit[101];
int bfs(int n){
    int dist[101];
    memset(dist,0,sizeof(dist));
    memset(visit,false,sizeof(visit));

    queue<int> q;
    q.push(n);
    visit[n]=true;
    dist[n]= 0;

    while(!q.empty()){
        int x= q.front();
        q.pop();

        for(int nx=1;nx<=N;nx++){
            if(a[x][nx]==1 && visit[nx]==false){
                
                dist[nx]= dist[x]+1;
                visit[nx]= true;
                q.push(nx);
            }
        }
    }
    int dist_sum=0;
    for(int i=1;i<=N;i++){
        dist_sum+= dist[i];
    }

    return dist_sum;
    
}
int main(){
    cin>>N>>M;
    memset(a,0,sizeof(a));
    for(int i=0;i<M;i++){
        int x,y;
        cin>>x>>y;
        a[x][y]=a[y][x]=1;
    }
    int min_idx =102 ; // 최소값과 최소값의 배열인덱스값을 알아야함. 
    int min_val = 700 ; //  6*101 
    for(int i=1;i<=N;i++){
        int tmp= bfs(i);
        if(tmp<min_val){
            min_val = tmp;
            min_idx = i;
        }
    }

    cout<< min_idx << '\n';

    return 0;
}