#include <vector>
#include <string>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> num1= {1,2,3,4,5};
vector<int> num2= {2,1,2,3,2,4,2,5};
vector<int> num3={3,3,1,1,2,2,4,4,5,5};

vector<int> test = {1,2};

int check(vector<int> answer, vector<int> num);
vector<int> solution (vector<int> answer);

int main(){
    vector<int> answers= {1,2,3,4,5};
    solution(answers);
    return 0;

}
int check(vector<int> answer, vector<int> num){
    int result = 0;
    int answer_s= answer.size();
    int num_s= num.size();

    //1. 정답 크기 <= 배열크기 : 정답크기만큼만 확인하면 됨 
    if(answer_s <= num_s){
        for(int i=0;i<answer_s;i++){
            if(answer[i]==num[i]) result++;
        }
    }
    //2. 정답 크기 > 배열크기 : 배열크기를 정답크기만큼 늘려줘야함.
    else{
        for(int i=0;i<answer_s;i++){
            if(answer[i]== num[i%num_s]) result++;
        }
    }
    return result;
}
vector<int> solution(vector<int> answers) {

    vector<int> answer;
    
    vector<int> v(3); 
    //1. check함수를 통해서 num1, num2, num3의 결과값 확인
    
    for(int i=0; i<answers.size();i++){
        // 배열처럼 0,1,2 인덱스를 사용하고싶으면 v(3)과 같이 크기를 선언해야함 
        if(answers[i]== num1[i%num1.size()]) v[0]++; 
        if(answers[i]== num2[i%num2.size()]) v[1]++;
        if(answers[i]== num3[i%num3.size()]) v[2]++; 
    }
    /*
    v.push_back(check(answers,num1));
    v.push_back(check(answers,num2));
    v.push_back(check(answers,num3));
    */
    //2. v에서 최대값을 구하고, 최대값과 같은 경우 answer에 넣는다. 
    int max_num = *max_element(v.begin(), v.end());
    for(int i=0;i<v.size();i++){
        if(v[i]==max_num) answer.push_back(i+1);
    }

    return answer;
}

