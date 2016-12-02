#include<bits/stdc++.h>
using namespace std;
int main(){
    int a,b;
    while(cin>>a>>b){
        vector<int>x;
        while(b--){
            int c;
            cin>>c;
            x.push_back(c);
        }
        int maxx = 0, posMax=0, posIni;
        for(int i =0 ;i<x.size();i++){
            int current = upper_bound(x.begin(),x.end(), x[i] + a - 1) - x.begin();
//            cout<<i<<" "<<current<<endl;
            if(maxx < (current - i)){
                maxx = current - i;
                posIni = i;
                posMax = current -1;
            }
        }
        cout<<maxx<<" "<<x[posIni]<<" "<<x[posMax]<<endl;
    }
}