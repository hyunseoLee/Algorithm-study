#include<queue>
#include<iostream>
#include<vector>
#include<cstring>
using namespace std;
#define MAX 20002
int a[MAX][MAX];
int d[MAX]; // 거리 결과값 저장
bool check[MAX];
int N,M;
vector<int> v[20002];
//vector<int> a[100002]; 
// vector<vector<int>> v(2002);

int ans =0; int cnt=0;
void bfs(){
    queue<int> q;
    q.push(1);
    check[1]= true;
    d[1]=0;

    while(!q.empty()){
        int x=q.front();
        q.pop();

        for(int i=0;i<v[x].size();i++){
            //int nx= i;
            //int i=0;i<v[1].size();i++ 
            //v[x][i];
            int nx = v[x][i];
            if(check[nx]==false){
                check[nx]=true;
                q.push(nx);
                d[nx]=d[x]+1;
                ans= max(d[nx],ans);

            }

        }
        /*
        for(int nx=1;nx<=N;nx++){
            if(a[x][nx]==1 && check[nx]==false){
                check[nx]=true;
                q.push(nx);
                d[nx]= d[x]+1;
                // 최대결과값. 갯수 비교          
                ans = max(d[nx],ans);
            }
        }
        */

    }

}

int main(){
    cin>>N>>M;
    //memset(a,0,sizeof(a));
    memset(check,false,sizeof(check));
    memset(d,0,sizeof(d));
    
    // a[x][y]=a[y][x]=1; 배열로 했더니 메모리 초과. 
    
    for(int i=0;i<M;i++){
        int x,y; //시작점과 종료점.
        cin>>x>>y;
        v[x].push_back(y);
        v[y].push_back(x);

        // a[x][y]=a[y][x]=1;
    }
    /*
    for(int i=0;i<v[1].size();i++){
        cout<<"v[1][i] : " <<v[1][i]<<' ';
    }
    cout<<'\n';
    */
    bfs();

    vector<int> result;
    for(int i=1;i<=N;i++){
        if(d[i]==ans){
            result.push_back(i);
        }
    }
    cout<< result[0] <<' '<<ans << ' '<< result.size() <<'\n';
    return 0;
}