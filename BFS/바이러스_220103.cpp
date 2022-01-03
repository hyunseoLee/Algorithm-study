#include <iostream>
#include <queue>

using namespace std;
int n,m;
int a[101][101];
bool check[101];
int main(){

    cin>>n>>m;

    for(int i=0;i<m;i++){
        int x,y;
        cin>>x>>y;
        a[x-1][y-1]=a[y-1][x-1]=1;
    }
    queue<int> q;
    q.push(0);
    check[0]=true;
    int cnt = -1;

    while(!q.empty()){ 
        int now = q.front();
        q.pop(); cnt++;
        for(int i=0;i<n;i++){
            if(check[i]==false && a[now][i]!= 0){
                q.push(i);
                check[i]=true;
            }
        }

    }

    cout<< cnt <<'\n';
    
    return 0;

}