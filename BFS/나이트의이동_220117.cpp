#include <iostream>
#include <queue>
#include <algorithm>
#include <cstdio>
#include <vector>
#include <cstring>
using namespace std;
bool check[301][301];
int ans[301][301];
int dx[8]= {-2,-2,1,1,-1,-1,2,2};
int dy[8]= {-1,1,-2,2,-2,2,-1,1};
int T,n;

int bfs(int x1,int y1, int x2, int y2){
    queue<pair<int,int>> q;
    q.push(make_pair(x1,y1));
    check[x1][y1]=true;
    //ans[x1][y1]=0; 
    
    //int ans =300*300;
    //int cnt =0;
    if(x1==x2 && y1==y2){
        return 0;
    }

    while(!q.empty()){
        int x= q.front().first;
        int y= q.front().second;
        q.pop();

        //cout<< x<< ","<<y <<'\n';

        for(int k=0;k<8;k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx==x2 && ny==y2){ // 최종목표지점 도달했다면.
                if(ans[x2][y2]==0) { ans[x2][y2]= ans[x][y]+1;}
                else { 
                    ans[x2][y2]= min( ans[x2][y2], ans[x][y]+1); 
                }
                
                //break; // 빠져나가도되겠지 ? 굳이 안빠져나가도 되는구나 ! 
            }
            //범위안에 있으면 계산 
            if(nx>=0 && nx<n && ny>=0 && ny<n && check[nx][ny]==false){
                q.push(make_pair(nx,ny));
                check[nx][ny]=true;
                ans[nx][ny]= ans[x][y]+1;
            }
            
        }
    }

    return ans[x2][y2];

}

int main(){

    cin>>T; 
    int start_x, start_y, end_x, end_y;
    vector<int> v;
    for(int t=0; t<T;t++){
        cin>>n;
        memset(check,false,sizeof(check));
        memset(ans,0,sizeof(ans));

        cin>>start_x >> start_y;
        cin>>end_x >> end_y; 

        v.push_back( bfs(start_x, start_y, end_x, end_y));
    }
    for(int i=0;i<v.size();i++){
        cout<<v[i]<<'\n';
    }
    return 0;
}