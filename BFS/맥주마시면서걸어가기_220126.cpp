#include <iostream>
#include <queue>
#include <vector>
#include <cstring>
#include <algorithm> // abs 사용하기 위한 STL 
using namespace std;
int T,N;
bool check[105];
int start_x,start_y,end_x,end_y;
vector<pair<int,int>> v; // 편의점 저장하는 벡터 
/*거리를 구하는 함수 getDistance*/
int getDistance(int x1,int y1, int x2, int y2){
    
    int distance = abs(x2-x1) + abs(y2-y1);
    return distance;
}
bool bfs(int x, int y){
    queue<pair<int,int>> q;
    q.push(make_pair(x,y));
    //check[x][y]=true;
    //int BeerCnt = 20;

    while(!q.empty()){
        int x= q.front().first;
        int y= q.front().second;
        q.pop();

        for(int i=0;i<v.size();i++){
            
            int dx= v[i].first;
            int dy= v[i].second;
            int num = i;
            
            // 만약, 거리가 1000 이하이고 현재 남은 맥주로 이동할 수 있다면 
            if(getDistance(x,y,dx,dy)<=1000 && check[num]==false ){
                // 만약 락페에 도착했다면 return 
                if(dx == end_x && dy==end_y){
                    return true;   
                }
                q.push(make_pair(dx,dy));
                check[num]=true;
            }
        }
    }

    return false;
}
int main(){ 

    //check 함수를 어떻게 할지 고민중....  배열값 다 받기엔 너무큰데 ? 
    
    
    vector<int> ans;
    cin>>T;
    while(T--){
        memset(check,false,sizeof(check));
        v.clear();
        cin>>N;
        cin>>start_x>>start_y;
  
        
        for(int i=0;i<N;i++){
            int x, y;
            cin>>x>>y;
            v.push_back(make_pair(x,y));
        }
        cin>>end_x>>end_y;
 
        v.push_back(make_pair(end_x, end_y));
        
        // 1. 상근-> 락페 까지 거리가 (50*20)1000 이상인 경우, bfs 함수 실행 
        if ( getDistance(start_x, start_y, end_x, end_y) <=1000 ){
            ans.push_back(1);
        }
        else{   
            if(bfs(start_x, start_y)) ans.push_back(1);
            else ans.push_back(0);
        }   
    }
    
    for(int i=0;i<ans.size();i++){
        if(ans[i]){
            cout<<"happy"<<'\n';
        }
        else cout<<"sad"<<'\n';
    }
    return 0;
}