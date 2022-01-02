#include <iostream>
#include <string>
using namespace std;
int main(){
    string a, b;
    cin>>a>>b;
    //1. 사이즈는 a<=b , 최대길이는 50
    int ans = 51;
    int length = b.size()- a.size();
    for(int start =0; start <= length; start++){
        int cnt =0;
        for(int i= 0; i<a.size();i++){
            if(a[i]!=b[start+i]) cnt++;
        }
        ans= min(ans,cnt);
    }
    cout << ans <<'\n';
    return 0;
}