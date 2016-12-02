#include<bits/stdc++.h>
using namespace std;
class UnionFind{
public:
    vector<int> p, rank;
    UnionFind(int n){
        rank.assign(n,0);
        p.assign(n,0);
        for(int i = 0;i<n;i++)
            p[i] = i;
    }
    int findSet(int i){
        return (i == p[i]) ? i:p[i] = findSet(p[i]);
    }
    bool isSameSet(int i, int j){
        return findSet(i) == findSet(j);
    }

    bool unionSet(int i, int j){
        if(!isSameSet(i,j)){
            int x = findSet(i);
            int y = findSet(j);
            if(rank[x] > rank[y]){
                p[y] = x;
            }else{
                p[x] = y;
                if(rank[x] == rank[y])
                rank[y]++;
            }
            return true;
        }else{
            return false;
        }
    }
};
int main(){

    int a,b;
    while(cin>>a){
        int xxx = -1;
        cin>>b;
        vector<pair<int, int> >pm;
        pm.push_back(pair<int,int>(a,b));
        xxx = max(xxx, max(a,b));
        while(cin>>a && a != -1){
            cin>>b;
            pm.push_back(pair<int,int>(a,b));
            xxx = max(xxx, max(a,b));
        }
        UnionFind uf(1000000);
        int ans = 0;
        for(int i=0;i<pm.size();i++){
            if(!uf.unionSet(pm[i].first , pm[i].second))
                ans++;

        }
        printf("%d\n", ans);
    }
    return 0;
}
