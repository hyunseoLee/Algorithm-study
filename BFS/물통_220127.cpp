#include <iostream>
#include <queue>
#include <vector>
#include <cstring>
#include <tuple> //tuple 사용하기 위한 STL 
using namespace std;
#define MAX 201
bool ans[MAX]; //결과값을 vetctor형으로 변환 가능.
bool check[MAX][MAX][MAX]; // 현재 A,B,C 물통의 값을 체크값으로 확인 
int Bucket[3];
void bfs(int a, int b, int c ){

    queue<tuple<int,int,int>> q;
    q.push(make_tuple(a,b,c));
    check[a][b][c]= true;
    ans[c] = true;

    while(!q.empty()){

        int n_a = get<0>(q.front());
        int n_b = get<1>(q.front());
        int n_c = get<2>(q.front());
        q.pop();

        //cout << n_a <<","<<n_b<<","<<n_c <<'\n';
        // a가 0 일때 c 물통의 값 저장
        if(n_a==0) ans[n_c]= true;

        /* 매 if문 마다 check 안하고
        if(!check[a][b][c]) { check[a][b][c]=true 후 if 문 실행해도 된다...} */
        //A물통을 옮겨보자.
        if(n_a>0){
            //1. a->b
            if(Bucket[1]-n_b >n_a ) { // A가 전부 채워줄수는 없음
                if(check[0][n_b+n_a][n_c]==false){
                    q.push(make_tuple(0, n_b+n_a, n_c));
                    check[0][n_b+n_a][n_c]= true;
                }

            }
            else{ //A가 전부 채워줌
                if(check[n_a- (Bucket[1]-n_b)][Bucket[1]][n_c]== false){
                q.push(make_tuple(n_a- (Bucket[1]-n_b), Bucket[1], n_c));
                check[n_a- (Bucket[1]-n_b)][Bucket[1]][n_c]= true;
                }
            }
            //2. a->c 
            if(Bucket[2]-n_c > n_a){ // a가 전부 채워줄수는 없음.
                if(check[0][n_b][n_a+n_c]==false){
                    q.push(make_tuple(0,n_b, n_a+n_c));
                    check[0][n_b][n_a+n_c]= true;
                }

            }
            else{
                if(check[n_a-(Bucket[2]-n_c)][n_b][Bucket[2]]== false){
                    q.push(make_tuple(n_a- (Bucket[2]-n_c),n_b, Bucket[2]));
                    check[n_a-(Bucket[2]-n_c)][n_b][Bucket[2]]=true;
                }
                
            }

        }
        //B물통을 옮겨보자.
        if(n_b>0){
            //1. b->a
            if( Bucket[0]-n_a > n_b) { //B가 전부 채워줄수는 없음 
                if(check[n_a+n_b][0][n_c]== false){
                    q.push(make_tuple(n_a+ n_b,0,n_c));
                    check[n_a+n_b][0][n_c]= true; 
                }
            }
            else{ //B가 전부 채워줄 수 있음.
                if(check[Bucket[0]][n_b-Bucket[0]-n_a][n_c]== false){
                    q.push(make_tuple(Bucket[0], n_b - (Bucket[0]-n_a), n_c));
                    check[Bucket[0]][n_b-Bucket[0]-n_a][n_c]= true;
                }
            }
            //2. b->c
            if( Bucket[2]-n_c > n_b) { // b가 전부 채워주지 못함 
                if(check[n_a][0][n_c+n_b] == false){
                    q.push(make_tuple(n_a, 0, n_c+n_b));
                    check[n_a][0][n_c+n_b] = true;
                }

            }
            else{
                if(check[n_a][n_b-(Bucket[2]-n_c)][Bucket[2]]== false){
                    q.push(make_tuple(n_a,n_b- (Bucket[2]-n_c) ,Bucket[2]));
                    check[n_a][n_b-(Bucket[2]-n_c)][Bucket[2]]= true;
                }

            }
        }
            

        //C물통을 옮겨보자.
        if(n_c>0){
            //1) c->a
            if(Bucket[0]- n_a > n_c)  { // 가득채울수 있는 양보다 C의 양이 작은 경우
                if(check[n_a +n_c][n_b][0] ==false){
                    q.push(make_tuple(n_a+n_c, n_b, 0));
                    check[n_a+n_c][n_b][0]= true;
                }
            }
            else{ // C가 가득 채울 수 있는 경우
                if(check[Bucket[0]][n_b][n_c- (Bucket[0]-n_a)] ==false ){
                    q.push(make_tuple(Bucket[0],n_b,n_c- (Bucket[0]-n_a)));
                    check[Bucket[0]][n_b][n_c- (Bucket[0]-n_a)] = true;
                }
            }
            //2) c->b
            if(Bucket[1]- n_b > n_c){
                if(check[n_a][n_b+n_c][0]==false){
                    q.push(make_tuple(n_a, n_b+n_c,0));
                    check[n_a][n_b+n_c][0] = true;
                }
            }
            else{ // C가 가득 채울 수 있는 경우! 
                if(check[n_a][Bucket[1]][n_c -(Bucket[1]-n_b)]== false ){
                    q.push(make_tuple(n_a, Bucket[1], n_c - (Bucket[1]-n_b)));
                    check[n_a][Bucket[1]][n_c -(Bucket[1]-n_b)] = true;
                }
            }
 
        }


    } 
}
int main(){

    memset(check,false,sizeof(check));
    memset(ans,false,sizeof(ans));

    for(int i=0;i<3;i++){
        int x;
        cin>>x;
        Bucket[i]=x;

    }
    //1. A,B 물통은 0/ C물통은 동일하게 초기화 

    bfs(0,0,Bucket[2]);

    for(int i=0;i<201;i++){
        if(ans[i]){
            cout<< i <<' ' ; 
        }
    }

    cout<< '\n';

    return 0;
}