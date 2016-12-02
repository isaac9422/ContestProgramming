#include<bits/stdc++.h>
using namespace std;
int main(){
    int n,m,r,c;
    while(cin>>n>>m>>r>>c && n+m+c+r){
        vector< vector<int > > target(n, vector<int>(m,0));
        vector< vector<int > > current(n, vector<int>(m,0));
        int res = 0;
        vector<string> entrada(n);
        for(int i=0;i<n;i++)
            cin>>entrada[i];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                target[i][j] = entrada[i][j] - '0';
                if(!(i  <= n -r && j <= m-c)) continue;
                if(target[i][j] != current[i][j]){
                        res++;
                    for(int k = i; k<i+r; k++){
                       for(int l = j; l<j+c; l++){

                            current[k][l] = current[k][l] ? 0:1;

                        }
                    }
                }
            }
        }
        bool ok = true;
        for(int i=0;i<n && ok;i++){
            for(int j=0;j<m && ok;j++){
                ok = current[i][j] == target[i][j];
            }
        }
        if(ok){
            cout<<res<<endl;
        }else{
            cout<<-1<<endl;
        }


    }
}
