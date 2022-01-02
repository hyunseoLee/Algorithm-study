#include <iostream>
#include <vector>
#include <string>
using namespace std;
vector<string> candy;
int n;
int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};

int candy_cnt(vector<string> candy){

    int ans= 0 ;
    int n= candy.size();
     // 1. 행에서 최대값 찾기 
    for(int i=0;i<n;i++){
        int cnt= 1;
       
        for(int j=0;j<n-1;j++){
            if(candy[i][j]==candy[i][j+1]){cnt++;}
            else {             
                cnt=1;
                
            }
            ans = max(cnt,ans);
            
        }
    }
    // 2. 열에서 최대값 찾기
    for(int i=0;i<n;i++){
        
        int cnt=1;
        for(int j=0;j<n-1;j++){
            if(candy[j][i]==candy[j+1][i]){cnt++;}
            else {
                cnt=1;
                
            }
            ans = max(cnt,ans);
             
        }
    }

    return ans;
}
int main(){
    int n;
    cin>>n;

    for(int i=0;i<n;i++){
        string str;
        cin>>str;
        candy.push_back(str);

    }
    //1. change 할 인접한 좌표를 구한다 
    int result=0;

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            for(int k=0;k<4;k++){
                int x = i +dx[k];
                int y = j +dy[k];
                //범위 안에 포함 된다면! 

                if(x>=0 && y>=0 && x<n && y<n && candy[i][j] != candy[x][y]){
                    swap(candy[i][j], candy[x][y]);

                    result = max(result, candy_cnt(candy));
                    swap(candy[i][j], candy[x][y]);
                    
                }
            }
        }
    }

    cout<< result <<'\n';

    return 0;
}

