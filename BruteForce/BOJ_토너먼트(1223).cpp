#include <iostream>
#include <cstdio>
#include <vector>

using namespace std;

int main(){
    int n,x,y;
    cin>>n>>x>>y;  
    vector<int> v;
    for(int i=0;i<n;i++){
        v.push_back(i+1);
    }

    int cnt=0;
    bool fight = true;

    //1 지민과 한수가 대결하기 전까지 반복해야함.
    while(fight){
        int size = v.size();
        vector<int> new_v;
         // 왜 맨처음에 0 이 들어가는거지 ?? vector<int> new_v(new_size);로 헸더니 
         // new_v[0] 값이 0으로 세팅됨.. 
        for(int i=0;i<size;i++){
            //다른 친구들의 숫자는 상관없으니, 맨 앞에있는 애로 승리시키기
            if(i%2==0){
                //지민&한수가 있는 경우, 무조건 지민&한수가 이기게
                if(v[i]== x || v[i]==y){
                    if(i+1<size){
                        if(v[i+1] == x || v[i+1] == y){
                            fight = false;
                            break; //민수와 한수가 만남 -m 가까운 반복문만 빠져나가기때문에 for문만 빠져나감. 
                        } 
                    }
                    new_v.push_back(v[i]); 
                }
                
                else if(i+1<size && (v[i+1]==x || v[i+1]==y )){
                    new_v.push_back(v[i+1]);  
                }
                else{
                    new_v.push_back(v[i]); 
                }
            }
        }
        cnt++;
        //new_v -> v 로 바꿔줘야한다.
        v.clear();
        v= new_v;
        new_v.clear();
        //v.erase(v.begin(),v.end());
    }

    cout << cnt <<'\n'; 

    return 0;
}