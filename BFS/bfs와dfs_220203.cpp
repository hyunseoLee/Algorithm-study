#include <iostream>
#include <vector>
#include <cstring>
#include <queue>
#include <algorithm>
using namespace std;
#define MAX  1002

int N,M,V ;
bool check[MAX];
vector<int> v[MAX];
vector<int> v1;
vector<int> v2;

void bfs(int x){
    queue<int> q;
    q.push(x);
    check[x]=true;

    while(!q.empty()){
        int x = q.front(); 
        q.pop();
        v2.push_back(x);

        for(int i=0;i<v[x].size();i++){
            int now = i;
            int val = v[x][now];
            if(check[val]== false){
                q.push(val);
                check[val]= true;
            }
        }
    }

}
void dfs(int x){
    //cout << "v1.size = " << v1.size() <<'\n';
    check[x]=true;
    v1.push_back(x);
    //cout << "dfs : "<< x <<'\n';

    for(int i=0;i<v[x].size();i++){
        int nx = i;
        int val = v[x][nx];
        if(check[val] == false){
            dfs(val);
        }
    }
}
int main(){
    cin>>N>>M>>V;
    
    memset(check,false,sizeof(check));

    for(int i=0;i<M;i++){   
        int x,y;
        cin>>x>>y;
        v[x].push_back(y);
        v[y].push_back(x);
        sort(v[x].begin(), v[x].end());
        sort(v[y].begin(), v[y].end());

    }

    dfs(V);
    memset(check,false,sizeof(check));
    bfs(V);

    //cout << "??" << v1.size() <<'\n';
    for(int i=0;i<v1.size();i++){
        cout<< v1[i] <<' ';
    }
    cout<<'\n';

    for(int i=0;i<v2.size();i++){
        cout<< v2[i] <<' ';
    }
    cout<<'\n';
    return 0; 
}