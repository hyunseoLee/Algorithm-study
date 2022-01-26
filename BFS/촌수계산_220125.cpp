#include<iostream>
#include<queue>
using namespace std;
int n,m;
int x,y;
bool check[101];
int cnt[101];
int a[101][101]; 
void bfs(int x ){
    check[x]= true;
    queue<int> q;
    q.push(x);
    
    cnt[x]=0 ;

    while(!q.empty()){
        int nx= q.front(); q.pop();
        
        if(nx == y) break;
        for(int i=0;i<=n;i++){
            if(a[nx][i]== 1 && check[i]==false){
                check[i]=true;
                q.push(i);
                cnt[i] = cnt[nx]+1;
            }
        }
    }


}
int main(){
    cin>>n; // 전체 사람 수
    cin>>x>>y;
    cin>>m;
    int ans;
    for(int i=0;i<m;i++){
        int x1,y1;
        cin >> x1>>y1;
        a[x1][y1]= a[y1][x1]=1;
    }

    
    bfs(x);

    if(cnt[y] == 0) {
        cout << "-1" <<'\n';
    }
    else   cout<< cnt[y] <<'\n';
    
    return 0;
}